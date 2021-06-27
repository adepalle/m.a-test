package fr.adepalle.domain.model

data class Task(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)