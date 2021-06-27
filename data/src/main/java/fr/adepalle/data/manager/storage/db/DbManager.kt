package fr.adepalle.data.manager.storage.db

import fr.adepalle.data.entity.db.TaskDBEntity
import fr.adepalle.data.entity.db.UserDBEntity

interface DbManager {
    fun getUserList(): List<UserDBEntity>
    fun getTaskByUserId(userId: Int): List<TaskDBEntity>
    fun saveUserList(userDBEntityList: List<UserDBEntity>)
    fun saveTaskList(taskDBEntityList: List<TaskDBEntity>)
    fun deleteAllUsers()
    fun deleteAllTaskFromUserId(userId: Int)
    fun deleteAllTasks()
}