package fr.adepalle.ma_test.component.error

import android.content.Context
import dagger.Reusable
import fr.adepalle.data.exception.OfflineException
import fr.adepalle.data.exception.RequestFailException
import fr.adepalle.data.exception.TaskRecoveryFailedException
import fr.adepalle.ma_test.R
import javax.inject.Inject

@Reusable
class ErrorTranslater @Inject constructor() {

    /**
     * Translate Exception into String
     */
    fun translate(context: Context, throwable: Throwable): String {
        return context.getString(
            when (throwable) {
                is RequestFailException -> R.string.error_request_failed
                is OfflineException -> R.string.error_offline
                is TaskRecoveryFailedException -> R.string.error_user_list_recovery_failed
                else -> R.string.error_general
            }
        )
    }
}