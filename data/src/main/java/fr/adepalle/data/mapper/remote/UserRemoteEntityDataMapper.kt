package fr.adepalle.data.mapper.remote

import dagger.Reusable
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import fr.adepalle.data.exception.MappingException
import javax.inject.Inject

@Reusable
class UserRemoteEntityDataMapper @Inject constructor() {
    fun transformRemoteEntity(remoteEntity: UserRemoteEntity): UserEntity {
        try {
            return UserEntity(
                id = remoteEntity.id,
                name = remoteEntity.username,
                username = remoteEntity.username,
                email = remoteEntity.email
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}