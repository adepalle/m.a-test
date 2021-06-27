package fr.adepalle.data.manager.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.adepalle.data.entity.db.TodoDBEntity

@Dao
interface TodoDao {

    @Query("Select * from TodoDBEntity where userId like :userId")
    fun findByUserId(userId: Int): List<TodoDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(todoDBEntityList: List<TodoDBEntity>)

    @Query("DELETE FROM TodoDBEntity")
    fun deleteAll()

    @Query("DELETE FROM TodoDBEntity where userId like :userId")
    fun deleteAllFromUserId(userId: Int)
}