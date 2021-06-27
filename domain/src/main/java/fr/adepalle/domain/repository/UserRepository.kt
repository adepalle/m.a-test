package fr.adepalle.domain.repository

import fr.adepalle.domain.model.Task
import fr.adepalle.domain.model.User
import io.reactivex.Single

interface UserRepository {
    fun retrieveAllUsers(): Single<List<User>>
    fun getTaskByUserId(userId: Int): Single<List<Task>>
    fun refreshAllUsers(): Single<List<User>>
    fun refreshTaskByUserId(userId: Int): Single<List<Task>>
}