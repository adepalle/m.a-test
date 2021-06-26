package fr.adepalle.domain.usecase.base

interface BaseParametrizedUseCase<in P, out R> {
    interface Callback<in R> {
        fun onSuccess(result: R)
        fun onError(throwable: Throwable)
    }

    suspend fun execute(params: P, callback: Callback<R>)
}