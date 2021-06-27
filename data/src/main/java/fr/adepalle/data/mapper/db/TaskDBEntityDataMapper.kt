package fr.adepalle.data.mapper.db

import android.util.Log
import dagger.Reusable
import fr.adepalle.data.entity.TaskEntity
import fr.adepalle.data.entity.db.TaskDBEntity
import fr.adepalle.data.mapper.base.DBMapper
import javax.inject.Inject

@Reusable
class TaskDBEntityDataMapper @Inject constructor() : DBMapper<TaskDBEntity, TaskEntity>() {

    override fun transformDBToEntity(input: TaskDBEntity): TaskEntity = TaskEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformEntityToDB(input: TaskEntity): TaskDBEntity = TaskDBEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TaskDBEntityDataMapper::class.toString(), error.toString())
    }
}