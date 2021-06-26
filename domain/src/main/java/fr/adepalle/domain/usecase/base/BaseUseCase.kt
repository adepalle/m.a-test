package fr.adepalle.domain.usecase.base

interface BaseUseCase<out R> {
    interface Callback<in R> {
        fun onSuccess(result: R)
        fun onError(throwable: Throwable)
    }

    suspend fun execute(callback: Callback<R>)
}