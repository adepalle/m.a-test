package fr.adepalle.domain.usecase

import fr.adepalle.domain.model.Todo
import fr.adepalle.domain.repository.UserRepository
import fr.adepalle.domain.usecase.base.BaseParametrizedUseCase
import javax.inject.Inject

class RetrieveAllTodosByUserId @Inject constructor(
    private val userRepository: UserRepository
) : BaseParametrizedUseCase<Int, List<Todo>> {

    override suspend fun execute(
        params: Int,
        callback: BaseParametrizedUseCase.Callback<List<Todo>>
    ) {
        try {
            val result = userRepository.getTodosByUserId(params)
            callback.onSuccess(result)
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}