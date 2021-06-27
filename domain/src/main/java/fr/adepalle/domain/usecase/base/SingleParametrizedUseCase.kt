package fr.adepalle.domain.usecase.base

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleParametrizedUseCase<T, P> : UseCase() {
    fun subscribe(params: P, onError: ((Throwable) -> Unit), onSuccess: ((T) -> Unit)) {
        disposable = build(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onSuccess, onError)
    }

    protected abstract fun build(params: P): Single<T>
}