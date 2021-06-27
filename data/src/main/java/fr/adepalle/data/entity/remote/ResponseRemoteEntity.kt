package fr.adepalle.data.entity.remote

import com.google.gson.annotations.SerializedName

data class ResponseRemoteEntity(
    @SerializedName("Response")
    val userRemoteEntityList: List<UserRemoteEntity>
)