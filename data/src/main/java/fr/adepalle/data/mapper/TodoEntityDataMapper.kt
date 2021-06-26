package fr.adepalle.data.mapper

import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.exception.MappingException
import fr.adepalle.domain.model.Todo
import javax.inject.Inject

class TodoEntityDataMapper @Inject constructor() {
    fun transformEntity(entity: TodoEntity): Todo {
        try {
            return Todo(
                id = entity.id,
                title = entity.title,
                completed = entity.completed
            )
        } catch (e: Exception) {
            throw MappingException()
        }
    }
}