package fr.adepalle.data.mapper

import android.util.Log
import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.mapper.base.ModelMapper
import fr.adepalle.domain.model.Todo
import javax.inject.Inject

class TodoEntityDataMapper @Inject constructor() : ModelMapper<Todo, TodoEntity>() {

    override fun transformModelToEntity(input: Todo): TodoEntity = TodoEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformEntityToModel(input: TodoEntity): Todo = Todo(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TodoEntityDataMapper::class.toString(), error.toString())
    }
}