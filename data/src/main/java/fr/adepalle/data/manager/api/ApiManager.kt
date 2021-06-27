package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TaskRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import io.reactivex.Single

interface ApiManager {
    fun getTaskByUserId(userId: Int): Single<List<TaskRemoteEntity>>
    fun getAllUsers(): Single<List<UserRemoteEntity>>
}