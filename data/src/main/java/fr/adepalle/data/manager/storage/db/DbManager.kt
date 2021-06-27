package fr.adepalle.data.manager.storage.db

import fr.adepalle.data.entity.db.TodoDBEntity
import fr.adepalle.data.entity.db.UserDBEntity

interface DbManager {
    fun getUserList(): List<UserDBEntity>
    fun getTodoByUserId(userId: Int): List<TodoDBEntity>
    fun saveUserList(userDBEntityList: List<UserDBEntity>)
    fun saveTodoList(todoDBEntityList: List<TodoDBEntity>)
    fun deleteAllUsers()
    fun deleteAllTodosFromUserId(userId: Int)
    fun deleteAllTodos()
}