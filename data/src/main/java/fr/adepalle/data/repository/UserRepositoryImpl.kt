package fr.adepalle.data.repository

import fr.adepalle.data.helper.UserBusinessHelper
import fr.adepalle.data.mapper.TodoEntityDataMapper
import fr.adepalle.data.mapper.UserEntityDataMapper
import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.model.User
import fr.adepalle.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userBusinessHelper: UserBusinessHelper,
    private val userEntityDataMapper: UserEntityDataMapper,
    private val todoEntityDataMapper: TodoEntityDataMapper
) : UserRepository {

    /**
     * Retrieve all users from database
     */
    override fun retrieveAllUsers(): Single<List<User>> = Single.defer {
        userBusinessHelper.getAllUsers().map {
            userEntityDataMapper.transformEntityList(it)
        }
    }

    /**
     * Retrieve todos by userId from database
     */
    override fun getTodosByUserId(userId: Int): Single<List<Todo>> = Single.defer {
        userBusinessHelper.getTodosByUserId(userId).map {
            todoEntityDataMapper.transformEntityList(it)
        }
    }

    /**
     * Refresh all users from API and save it into database
     */
    override fun refreshAllUsers(): Single<List<User>> = Single.defer {
        userBusinessHelper.saveUserList().andThen(Single.defer {
            userBusinessHelper.getAllUsers()
                .map { userEntityDataMapper.transformEntityList(it) }
        })
    }

    /**
     * Refresh todos by userId from API and save it into database
     */
    override fun refreshTodosByUserId(userId: Int): Single<List<Todo>> = Single.defer {
        userBusinessHelper.saveTodoList(userId).andThen(Single.defer {
            userBusinessHelper.getTodosByUserId(userId)
                .map { todoEntityDataMapper.transformEntityList(it) }
        })
    }
}