package fr.adepalle.ma_test.component.snackbar

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.component.error.ErrorTranslater
import fr.adepalle.ma_test.extensions.getColorFromAttr
import javax.inject.Inject

class SnackbarComponentImpl @Inject constructor(
    private val errorTranslater: ErrorTranslater
) : SnackbarComponent {

    override fun displaySuccess(context: Context, content: Int, view: View?) {
        view?.let {
            Snackbar.make(it, context.getString(content), Snackbar.LENGTH_LONG).apply {
                with(this.view) {
                    setBackgroundColor(context.getColorFromAttr(R.attr.snackbarSuccessBackground))
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                }
            }.show()
        }
    }

    override fun displayError(context: Context, throwable: Throwable, view: View?) {
        view?.let {
            Snackbar.make(it, errorTranslater.translate(context, throwable), Snackbar.LENGTH_LONG)
                .apply {
                    with(this.view) {
                        setBackgroundColor(context.getColorFromAttr(R.attr.snackbarErrorBackground))
                        setTextColor(ContextCompat.getColor(context, R.color.white))
                    }
                }.show()
        }
    }

    override fun displayWarning(context: Context, content: Int, view: View?) {
        view?.let {
            Snackbar.make(it, context.getString(content), Snackbar.LENGTH_LONG).apply {
                with(this.view) {
                    setBackgroundColor(context.getColorFromAttr(R.attr.snackbarWarningBackground))
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                }
            }.show()
        }
    }

}