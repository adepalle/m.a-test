package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity

interface ApiManager {
    suspend fun getTodosByUserId(userId: Int): List<TodoRemoteEntity>
    suspend fun getAllUsers(): List<UserRemoteEntity>
}