package fr.adepalle.data.mapper

import dagger.Reusable
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.exception.MappingException
import fr.adepalle.domain.model.User
import javax.inject.Inject

@Reusable
class UserEntityDataMapper @Inject constructor() {
    fun transformEntity(entity: UserEntity): User {
        try {
            return User(
                id = entity.id,
                name = entity.username,
                username = entity.username,
                email = entity.email
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}