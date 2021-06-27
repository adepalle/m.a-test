package fr.adepalle.data.manager.api.service

import fr.adepalle.data.entity.remote.TaskRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface UserTaskServiceApi {

    @GET("todos")
    fun getTaskByUserId(@Query("userId") userId: Int): Single<List<TaskRemoteEntity>>

    @GET("users")
    fun getAllUsers(): Single<List<UserRemoteEntity>>
}