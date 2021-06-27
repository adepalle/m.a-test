package fr.adepalle.data.manager.storage.db

import fr.adepalle.data.entity.db.TodoDBEntity
import fr.adepalle.data.entity.db.UserDBEntity
import fr.adepalle.data.manager.storage.db.dao.TodoDao
import fr.adepalle.data.manager.storage.db.dao.UserDao
import javax.inject.Inject

class DbManagerImpl @Inject constructor(appDatabase: AppDatabase) : DbManager {

    private val userDao: UserDao = appDatabase.userDao()
    private val todoDao: TodoDao = appDatabase.todoDao()

    override fun getUserList(): List<UserDBEntity> {
        return userDao.getAll()
    }

    override fun getTodoByUserId(userId: Int): List<TodoDBEntity> {
        return todoDao.findByUserId(userId)
    }

    override fun saveUserList(userDBEntityList: List<UserDBEntity>) {
        userDao.insertAll(userDBEntityList)
    }

    override fun saveTodoList(todoDBEntityList: List<TodoDBEntity>) {
        todoDao.insertAll(todoDBEntityList)
    }

    override fun deleteAllUsers() {
        userDao.deleteAll()
    }

    override fun deleteAllTodosFromUserId(userId: Int) {
        todoDao.deleteAllFromUserId(userId)
    }

    override fun deleteAllTodos() {
        todoDao.deleteAll()
    }
}