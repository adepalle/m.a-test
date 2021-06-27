package fr.adepalle.domain.repository

import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {
    fun retrieveAllUsers(): Single<List<User>>
    fun getTodosByUserId(userId: Int): Single<List<Todo>>
    fun refreshAllUsers(): Single<List<User>>
    fun refreshTodosByUserId(userId: Int): Single<List<Todo>>
}