package fr.adepalle.domain.repository

import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.model.User

interface UserRepository {
    suspend fun getAllUsers(): List<User>
    suspend fun getTodosByUserId(userId: Int): List<Todo>
}