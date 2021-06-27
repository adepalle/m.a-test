package fr.adepalle.domain.usecase

import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.repository.UserRepository
import fr.adepalle.domain.usecase.base.SingleParametrizedUseCase
import io.reactivex.Single
import javax.inject.Inject

class RetrieveAllTodosByUserId @Inject constructor(
    private val userRepository: UserRepository
) : SingleParametrizedUseCase<List<Todo>, RetrieveAllTodosByUserId.Params>() {

    override fun build(params: Params): Single<List<Todo>> {
        return userRepository.getTodosByUserId(params.userId)
    }

    data class Params(val userId: Int)

}