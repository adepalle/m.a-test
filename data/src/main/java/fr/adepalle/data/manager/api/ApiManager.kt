package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import io.reactivex.Single

interface ApiManager {
    fun getTodosByUserId(userId: Int): Single<List<TodoRemoteEntity>>
    fun getAllUsers(): Single<List<UserRemoteEntity>>
}