package fr.adepalle.domain.usecase

import fr.adepalle.domain.model.Task
import fr.adepalle.domain.repository.UserRepository
import fr.adepalle.domain.usecase.base.SingleParametrizedUseCase
import io.reactivex.Single
import javax.inject.Inject

class RetrieveAllTaskByUserId @Inject constructor(
    private val userRepository: UserRepository
) : SingleParametrizedUseCase<List<Task>, RetrieveAllTaskByUserId.Params>() {

    override fun build(params: Params): Single<List<Task>> {
        return userRepository.getTaskByUserId(params.userId)
    }

    data class Params(val userId: Int)

}