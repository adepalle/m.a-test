package fr.adepalle.data.mapper.remote

import android.util.Log
import fr.adepalle.data.entity.TaskEntity
import fr.adepalle.data.entity.remote.TaskRemoteEntity
import fr.adepalle.data.mapper.base.RemoteMapper
import javax.inject.Inject

class TaskRemoteEntityDataMapper @Inject constructor() :
    RemoteMapper<TaskRemoteEntity, TaskEntity>() {

    override fun transformEntityToRemote(input: TaskEntity): TaskRemoteEntity = TaskRemoteEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun transformRemoteToEntity(input: TaskRemoteEntity): TaskEntity = TaskEntity(
        userId = input.userId,
        id = input.id,
        title = input.title,
        completed = input.completed
    )

    override fun onMappingError(error: Exception) {
        Log.e(TaskRemoteEntityDataMapper::class.toString(), error.toString())
    }
}