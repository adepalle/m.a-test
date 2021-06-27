package fr.adepalle.data.manager.storage.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.adepalle.data.entity.db.TaskDBEntity
import fr.adepalle.data.entity.db.UserDBEntity
import fr.adepalle.data.manager.storage.db.dao.TaskDao
import fr.adepalle.data.manager.storage.db.dao.UserDao

/**
 * This is the App Database
 * We provide all DB Entities, Dao and Converters here
 */
@Database(
    entities = [
        UserDBEntity::class,
        TaskDBEntity::class
    ], version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun taskDao(): TaskDao

    /**
     * We use a companion object so that future migrations will be added in relevant class (here) and not in DI module
     */
    companion object {
        private const val DATABASE_NAME = "ma-test-db"

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(AppDatabase::class) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }.also { INSTANCE = it }
        }
    }
}