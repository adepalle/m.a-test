package fr.adepalle.data.helper

import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.manager.api.ApiManager
import fr.adepalle.data.mapper.remote.TodoRemoteEntityDataMapper
import fr.adepalle.data.mapper.remote.UserRemoteEntityDataMapper
import javax.inject.Inject

class UserBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val userRemoteEntityDataMapper: UserRemoteEntityDataMapper,
    private val todoRemoteEntityDataMapper: TodoRemoteEntityDataMapper
) {
    suspend fun getAllUsers(): List<UserEntity> {
        return apiManager.getAllUsers().map {
            userRemoteEntityDataMapper.transformRemoteEntity(it)
        }
    }

    suspend fun getTodosByUserId(userId: Int): List<TodoEntity> {
        return apiManager.getTodosByUserId(userId).map {
            todoRemoteEntityDataMapper.transformRemoteEntity(it)
        }
    }
}