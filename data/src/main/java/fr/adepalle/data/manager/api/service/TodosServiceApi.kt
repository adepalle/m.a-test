package fr.adepalle.data.manager.api.service

import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface TodosServiceApi {

    @GET("todos")
    suspend fun getTodosByUserId(@Query("userId") userId: Int): List<TodoRemoteEntity>

    @GET("users")
    suspend fun getAllUsers(): List<UserRemoteEntity>
}