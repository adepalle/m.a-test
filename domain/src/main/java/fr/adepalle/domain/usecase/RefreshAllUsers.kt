package fr.adepalle.domain.usecase

import fr.adepalle.domain.model.User
import fr.adepalle.domain.repository.UserRepository
import fr.adepalle.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class RefreshAllUsers @Inject constructor(
    private val userRepository: UserRepository
) : SingleUseCase<List<User>>() {

    override fun build(): Single<List<User>> {
        return userRepository.refreshAllUsers()
    }

}