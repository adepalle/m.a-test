package fr.adepalle.data.entity

data class TodoEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)
