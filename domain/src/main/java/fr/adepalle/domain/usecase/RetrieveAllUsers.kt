package fr.adepalle.domain.usecase

import fr.adepalle.domain.model.User
import fr.adepalle.domain.repository.UserRepository
import fr.adepalle.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class RetrieveAllUsers @Inject constructor(
    private val userRepository: UserRepository
) : BaseUseCase<List<User>> {
    override suspend fun execute(callback: BaseUseCase.Callback<List<User>>) {
        try {
            val result = userRepository.getAllUsers()
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}