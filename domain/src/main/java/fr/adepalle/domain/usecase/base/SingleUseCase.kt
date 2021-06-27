package fr.adepalle.domain.usecase.base

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T> : UseCase() {
    fun subscribe(onError: ((Throwable) -> Unit), onSuccess: ((T) -> Unit)) {
        disposable = build()
            .subscribeOn(Schedulers.from(threadExecutor))
            .subscribe(onSuccess, onError)
    }

    protected abstract fun build(): Single<T>
}