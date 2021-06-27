package fr.adepalle.data.mapper

import android.util.Log
import fr.adepalle.data.entity.TaskEntity
import fr.adepalle.data.mapper.base.ModelMapper
import fr.adepalle.domain.model.Task
import javax.inject.Inject

class TaskEntityDataMapper @Inject constructor() : ModelMapper<Task, TaskEntity>() {

    override fun transformModelToEntity(input: Task): TaskEntity = TaskEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformEntityToModel(input: TaskEntity): Task = Task(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TaskEntityDataMapper::class.toString(), error.toString())
    }
}