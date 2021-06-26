package fr.adepalle.data.entity.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoDBEntity(
    @PrimaryKey val userId: Int,
    @ColumnInfo val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val completed: Boolean,
)