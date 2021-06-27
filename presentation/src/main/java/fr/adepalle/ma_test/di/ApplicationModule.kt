package fr.adepalle.ma_test.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.adepalle.ma_test.component.snackbar.SnackbarComponent
import fr.adepalle.ma_test.component.snackbar.SnackbarComponentImpl

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @JvmStatic
    @Provides
    @Reusable
    fun snackbarComponent(snackbarComponentImpl: SnackbarComponentImpl): SnackbarComponent =
        snackbarComponentImpl
}