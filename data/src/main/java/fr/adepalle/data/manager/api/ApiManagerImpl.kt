package fr.adepalle.data.manager.api

import fr.adepalle.data.entity.remote.TodoRemoteEntity
import fr.adepalle.data.entity.remote.UserRemoteEntity
import fr.adepalle.data.manager.api.service.TodosServiceApi
import io.reactivex.Single
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(
    private val countryServiceApi: TodosServiceApi
) : ApiManager {

    override fun getAllUsers(): Single<List<UserRemoteEntity>> {
        return countryServiceApi.getAllUsers()
    }

    override fun getTodosByUserId(userId: Int): Single<List<TodoRemoteEntity>> {
        return countryServiceApi.getTodosByUserId(userId = userId)
    }
}