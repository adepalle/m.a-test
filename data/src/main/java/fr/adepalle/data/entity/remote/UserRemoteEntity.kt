package fr.adepalle.data.entity.remote

import com.google.gson.annotations.SerializedName

data class UserRemoteEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String
)
