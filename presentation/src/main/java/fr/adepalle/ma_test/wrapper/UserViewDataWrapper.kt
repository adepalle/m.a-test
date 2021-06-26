package fr.adepalle.ma_test.wrapper

import fr.adepalle.domain.model.User

class UserViewDataWrapper(private val user: User) {
    fun getId() = user.id
    fun getName() = user.name
    fun getUserName() = user.username
    fun getMail() = user.email
}