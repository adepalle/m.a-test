package fr.adepalle.data.manager.storage.db

import fr.adepalle.data.entity.db.TaskDBEntity
import fr.adepalle.data.entity.db.UserDBEntity
import fr.adepalle.data.manager.storage.db.dao.TaskDao
import fr.adepalle.data.manager.storage.db.dao.UserDao
import javax.inject.Inject

class DbManagerImpl @Inject constructor(appDatabase: AppDatabase) : DbManager {

    private val userDao: UserDao = appDatabase.userDao()
    private val taskDao: TaskDao = appDatabase.taskDao()

    override fun getUserList(): List<UserDBEntity> {
        return userDao.getAll()
    }

    override fun getTaskByUserId(userId: Int): List<TaskDBEntity> {
        return taskDao.findByUserId(userId)
    }

    override fun saveUserList(userDBEntityList: List<UserDBEntity>) {
        userDao.insertAll(userDBEntityList)
    }

    override fun saveTaskList(taskDBEntityList: List<TaskDBEntity>) {
        taskDao.insertAll(taskDBEntityList)
    }

    override fun deleteAllUsers() {
        userDao.deleteAll()
    }

    override fun deleteAllTaskFromUserId(userId: Int) {
        taskDao.deleteAllFromUserId(userId)
    }

    override fun deleteAllTasks() {
        taskDao.deleteAll()
    }
}