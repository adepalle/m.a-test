package fr.adepalle.data.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fr.adepalle.data.executor.JobExecutor
import fr.adepalle.data.manager.storage.db.AppDatabase
import fr.adepalle.data.repository.UserRepositoryImpl
import fr.adepalle.domain.executor.ThreadExecutor
import fr.adepalle.domain.repository.UserRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun providesUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideJobExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

}