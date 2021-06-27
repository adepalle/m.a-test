package fr.adepalle.data.manager.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.adepalle.data.entity.db.TaskDBEntity

@Dao
interface TaskDao {

    @Query("Select * from TaskDBEntity where userId like :userId")
    fun findByUserId(userId: Int): List<TaskDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(taskDBEntityList: List<TaskDBEntity>)

    @Query("DELETE FROM TaskDBEntity")
    fun deleteAll()

    @Query("DELETE FROM TaskDBEntity where userId like :userId")
    fun deleteAllFromUserId(userId: Int)
}