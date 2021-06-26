package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import fr.adepalle.data.manager.api.service.TodosServiceApi
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(
    private val countryServiceApi: TodosServiceApi
) : ApiManager {

    override suspend fun getAllUsers(): List<UserRemoteEntity> {
        return countryServiceApi.getAllUsers()
    }

    override suspend fun getTodosByUserId(userId: Int): List<TodoRemoteEntity> {
        return countryServiceApi.getTodosByUserId(userId = userId)
    }
}