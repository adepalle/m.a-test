package fr.adepalle.data.repository

import fr.adepalle.data.helper.UserBusinessHelper
import fr.adepalle.data.mapper.TaskEntityDataMapper
import fr.adepalle.data.mapper.UserEntityDataMapper
import fr.adepalle.domain.model.Task
import fr.adepalle.domain.model.User
import fr.adepalle.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userBusinessHelper: UserBusinessHelper,
    private val userEntityDataMapper: UserEntityDataMapper,
    private val taskEntityDataMapper: TaskEntityDataMapper
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
     * Retrieve tasks by userId from database
     */
    override fun getTaskByUserId(userId: Int): Single<List<Task>> = Single.defer {
        userBusinessHelper.getTaskByUserId(userId).map {
            taskEntityDataMapper.transformEntityList(it)
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
     * Refresh tasks by userId from API and save it into database
     */
    override fun refreshTaskByUserId(userId: Int): Single<List<Task>> = Single.defer {
        userBusinessHelper.saveTaskList(userId).andThen(Single.defer {
            userBusinessHelper.getTaskByUserId(userId)
                .map { taskEntityDataMapper.transformEntityList(it) }
        })
    }
}