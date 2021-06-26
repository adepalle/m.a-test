package fr.adepalle.data.repository

import fr.adepalle.data.helper.UserBusinessHelper
import fr.adepalle.data.mapper.TodoEntityDataMapper
import fr.adepalle.data.mapper.UserEntityDataMapper
import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.model.User
import fr.adepalle.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userBusinessHelper: UserBusinessHelper,
    private val userEntityDataMapper: UserEntityDataMapper,
    private val todoEntityDataMapper: TodoEntityDataMapper
) : UserRepository {
    override suspend fun getAllUsers(): List<User> {
        return userBusinessHelper.getAllUsers().map {
            userEntityDataMapper.transformEntityToModel(it)
        }
    }

    override suspend fun getTodosByUserId(userId: Int): List<Todo> {
        return userBusinessHelper.getTodosByUserId(userId).map {
            todoEntityDataMapper.transformEntityToModel(it)
        }
    }
}