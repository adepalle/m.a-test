package fr.adepalle.data.mapper.db

import android.util.Log
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.entity.db.UserDBEntity
import fr.adepalle.data.mapper.base.DBMapper
import javax.inject.Inject

class UserDBEntityDataMapper @Inject constructor() : DBMapper<UserDBEntity, UserEntity>() {

    override fun transformDBToEntity(input: UserDBEntity): UserEntity = UserEntity(
        id = input.id,
        name = input.name,
        username = input.username,
        email = input.email
    )

    override fun transformEntityToDB(input: UserEntity): UserDBEntity = UserDBEntity(
        id = input.id,
        name = input.name,
        username = input.username,
        email = input.email
    )

    override fun onMappingError(error: Exception) {
        Log.e(UserDBEntityDataMapper::class.toString(), error.toString())
    }
}