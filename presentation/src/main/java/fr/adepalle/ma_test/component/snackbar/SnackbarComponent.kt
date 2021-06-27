package fr.adepalle.ma_test.component.snackbar

import android.content.Context
import android.view.View
import androidx.annotation.StringRes

interface SnackbarComponent {
    /**
     * Display success Snackbar
     */
    fun displaySuccess(context: Context, @StringRes content: Int, view: View?)

    /**
     * Display error Snackbar from Exception
     */
    fun displayError(context: Context, throwable: Throwable, view: View?)

    /**
     * Display warning Snackbar
     */
    fun displayWarning(context: Context, @StringRes content: Int, view: View?)

}