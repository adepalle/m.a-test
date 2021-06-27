package fr.adepalle.data.helper

import fr.adepalle.data.entity.TaskEntity
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.exception.TaskRecoveryFailedException
import fr.adepalle.data.exception.UserRecoveryFailedExcetion
import fr.adepalle.data.manager.api.ApiManager
import fr.adepalle.data.manager.storage.db.DbManager
import fr.adepalle.data.mapper.db.TaskDBEntityDataMapper
import fr.adepalle.data.mapper.db.UserDBEntityDataMapper
import fr.adepalle.data.mapper.remote.TaskRemoteEntityDataMapper
import fr.adepalle.data.mapper.remote.UserRemoteEntityDataMapper
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val dbManager: DbManager,
    private val userRemoteEntityDataMapper: UserRemoteEntityDataMapper,
    private val userDBEntityDataMapper: UserDBEntityDataMapper,
    private val taskRemoteEntityDataMapper: TaskRemoteEntityDataMapper,
    private val taskDBEntityDataMapper: TaskDBEntityDataMapper
) {
    fun saveUserList(): Completable {
        return apiManager.getAllUsers().map {
            userRemoteEntityDataMapper.transformRemoteEntityList(it)
        }.doOnSuccess { apiUserList ->
            dbManager.deleteAllUsers()
            dbManager.saveUserList(userDBEntityDataMapper.transformEntityList(apiUserList))
        }.ignoreElement().onErrorResumeNext { Completable.error(UserRecoveryFailedExcetion()) }
    }

    fun saveTaskList(userId: Int): Completable {
        return apiManager.getTaskByUserId(userId).map {
            taskRemoteEntityDataMapper.transformRemoteEntityList(it)
        }.doOnSuccess { taskUserList ->
            dbManager.deleteAllTaskFromUserId(userId)
            dbManager.saveTaskList(taskDBEntityDataMapper.transformEntityList(taskUserList))
        }.ignoreElement().onErrorResumeNext { Completable.error(TaskRecoveryFailedException()) }
    }

    fun getAllUsers(): Single<List<UserEntity>> {
        return Single.just(userDBEntityDataMapper.transformDBEntityList(dbManager.getUserList()))
    }

    fun getTaskByUserId(userId: Int): Single<List<TaskEntity>> {
        return Single.just(
            taskDBEntityDataMapper.transformDBEntityList(
                dbManager.getTaskByUserId(
                    userId
                )
            )
        )
    }
}