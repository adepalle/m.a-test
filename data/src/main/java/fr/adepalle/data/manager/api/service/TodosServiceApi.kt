package fr.adepalle.data.manager.api.service

import fr.adepalle.data.entity.remote.ResponseRemoteEntity
import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TodosServiceApi {

    @GET("todos")
    fun getTodosByUserId(@Query("userId") userId: Int): Single<List<TodoRemoteEntity>>

    @GET("users")
    fun getAllUsers(): Single<List<UserRemoteEntity>>
}