package fr.adepalle.data.mapper.remote

import android.util.Log
import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.exception.MappingException
import fr.adepalle.data.mapper.base.RemoteMapper
import javax.inject.Inject

class TodoRemoteEntityDataMapper @Inject constructor() :
    RemoteMapper<TodoRemoteEntity, TodoEntity>() {

    override fun transformEntityToRemote(input: TodoEntity): TodoRemoteEntity = TodoRemoteEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformRemoteToEntity(input: TodoRemoteEntity): TodoEntity = TodoEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TodoRemoteEntityDataMapper::class.toString(), error.toString())
    }
}