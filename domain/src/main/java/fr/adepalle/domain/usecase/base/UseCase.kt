package fr.adepalle.domain.usecase.base

import fr.adepalle.domain.executor.ThreadExecutor
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class UseCase {
    @Inject
    protected lateinit var threadExecutor: ThreadExecutor

    protected var disposable: Disposable? = null

    fun unsubscribe() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }
}