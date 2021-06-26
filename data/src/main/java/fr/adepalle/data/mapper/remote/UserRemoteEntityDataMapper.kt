package fr.adepalle.data.mapper.remote

import android.util.Log
import dagger.Reusable
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import fr.adepalle.data.mapper.base.RemoteMapper
import javax.inject.Inject

@Reusable
class UserRemoteEntityDataMapper @Inject constructor() :
    RemoteMapper<UserRemoteEntity, UserEntity>() {

    override fun transformEntityToRemote(input: UserEntity): UserRemoteEntity = UserRemoteEntity(
        id = input.id,
        name = input.username,
        username = input.username,
        email = input.email
    )

    override fun transformRemoteToEntity(input: UserRemoteEntity): UserEntity = UserEntity(
        id = input.id,
        name = input.username,
        username = input.username,
        email = input.email
    )

    override fun onMappingError(error: Exception) {
        Log.e(UserRemoteEntityDataMapper::class.toString(), error.toString())
    }
}