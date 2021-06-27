package fr.adepalle.data.mapper

import android.util.Log
import dagger.Reusable
import fr.adepalle.data.entity.UserEntity
import fr.adepalle.data.mapper.base.ModelMapper
import fr.adepalle.domain.model.User
import javax.inject.Inject

@Reusable
class UserEntityDataMapper @Inject constructor() : ModelMapper<User, UserEntity>() {

    override fun onMappingError(error: Exception) {
        Log.e(UserEntityDataMapper::class.toString(), error.toString())
    }

    override fun transformModelToEntity(input: User): UserEntity = UserEntity(
        id = input.id,
        name = input.name,
        username = input.username,
        email = input.email
    )

    override fun transformEntityToModel(input: UserEntity): User = User(
        id = input.id,
        name = input.name,
        username = input.username,
        email = input.email
    )
}