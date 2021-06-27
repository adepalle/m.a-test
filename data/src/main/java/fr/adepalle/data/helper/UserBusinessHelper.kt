package fr.adepalle.data.helper

import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.exception.TodoRecoveryFailedException
import fr.adepalle.data.exception.UserRecoveryFailedExcetion
import fr.adepalle.data.manager.api.ApiManager
import fr.adepalle.data.manager.storage.db.DbManager
import fr.adepalle.data.mapper.db.TodoDBEntityDataMapper
import fr.adepalle.data.mapper.db.UserDBEntityDataMapper
import fr.adepalle.data.mapper.remote.TodoRemoteEntityDataMapper
import fr.adepalle.data.mapper.remote.UserRemoteEntityDataMapper
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserBusinessHelper @Inject constructor(
    private val apiManager: ApiManager,
    private val dbManager: DbManager,
    private val userRemoteEntityDataMapper: UserRemoteEntityDataMapper,
    private val userDBEntityDataMapper: UserDBEntityDataMapper,
    private val todoRemoteEntityDataMapper: TodoRemoteEntityDataMapper,
    private val todoDBEntityDataMapper: TodoDBEntityDataMapper
) {
    fun saveUserList(): Completable {
        return apiManager.getAllUsers().map {
            userRemoteEntityDataMapper.transformRemoteEntityList(it)
        }.doOnSuccess { apiUserList ->
            dbManager.deleteAllUsers()
            dbManager.saveUserList(userDBEntityDataMapper.transformEntityList(apiUserList))
        }.ignoreElement().onErrorResumeNext { Completable.error(UserRecoveryFailedExcetion()) }
    }

    fun saveTodoList(userId: Int): Completable {
        return apiManager.getTodosByUserId(userId).map {
            todoRemoteEntityDataMapper.transformRemoteEntityList(it)
        }.doOnSuccess { todoUserList ->
            dbManager.deleteAllTodosFromUserId(userId)
            dbManager.saveTodoList(todoDBEntityDataMapper.transformEntityList(todoUserList))
        }.ignoreElement().onErrorResumeNext { Completable.error(TodoRecoveryFailedException()) }
    }

    fun getAllUsers(): Single<List<UserEntity>> {
        return Single.just(userDBEntityDataMapper.transformDBEntityList(dbManager.getUserList()))
    }

    fun getTodosByUserId(userId: Int): Single<List<TodoEntity>> {
        return Single.just(
            todoDBEntityDataMapper.transformDBEntityList(
                dbManager.getTodoByUserId(
                    userId
                )
            )
        )
    }
}