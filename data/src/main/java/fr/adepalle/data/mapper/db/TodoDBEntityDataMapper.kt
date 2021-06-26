package fr.adepalle.data.mapper.db

import android.util.Log
import dagger.Reusable
import fr.adepalle.data.entity.TodoEntity
import fr.adepalle.data.entity.db.TodoDBEntity
import fr.adepalle.data.mapper.base.DBMapper
import javax.inject.Inject

@Reusable
class TodoDBEntityDataMapper @Inject constructor() : DBMapper<TodoDBEntity, TodoEntity>() {

    override fun transformDBToEntity(input: TodoDBEntity): TodoEntity = TodoEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformEntityToDB(input: TodoEntity): TodoDBEntity = TodoDBEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TodoDBEntityDataMapper::class.toString(), error.toString())
    }
}