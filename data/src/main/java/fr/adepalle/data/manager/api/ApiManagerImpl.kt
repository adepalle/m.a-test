package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TaskRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import fr.adepalle.data.manager.api.service.UserTaskServiceApi
import io.reactivex.Single
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(
    private val countryServiceApi: UserTaskServiceApi
) : ApiManager {

    override fun getAllUsers(): Single<List<UserRemoteEntity>> {
        return countryServiceApi.getAllUsers()
    }

    override fun getTaskByUserId(userId: Int): Single<List<TaskRemoteEntity>> {
        return countryServiceApi.getTaskByUserId(userId = userId)
    }
}