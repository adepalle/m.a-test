package fr.adepalle.data.mapper.remote

import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.exception.MappingException
import javax.inject.Inject

class TodoRemoteEntityDataMapper @Inject constructor() {
    fun transformRemoteEntity(remoteEntity: TodoRemoteEntity): TodoEntity {
        try {
            return TodoEntity(
                id = remoteEntity.id,
                title = remoteEntity.title,
                completed = remoteEntity.completed
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}