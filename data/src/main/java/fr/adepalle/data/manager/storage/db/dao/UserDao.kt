package fr.adepalle.data.manager.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.adepalle.data.entity.db.UserDBEntity

@Dao
interface UserDao {

    @Query("Select * from UserDBEntity")
    fun getAll(): List<UserDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(userDBEntityList: List<UserDBEntity>)

    @Query("DELETE FROM UserDBEntity")
    fun deleteAll()
}