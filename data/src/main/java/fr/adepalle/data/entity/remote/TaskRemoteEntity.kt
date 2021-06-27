package fr.adepalle.data.entity.remote

import com.google.gson.annotations.SerializedName

data class TaskRemoteEntity(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)