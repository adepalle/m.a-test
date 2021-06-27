package fr.adepalle.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.adepalle.data.manager.api.ApiManager
import fr.adepalle.data.manager.api.ApiManagerImpl
import fr.adepalle.data.manager.storage.db.DbManager
import fr.adepalle.data.manager.storage.db.DbManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ManagerModule {

    @Provides
    @Singleton
    fun provideApiManager(apiManagerImpl: ApiManagerImpl): ApiManager {
        return apiManagerImpl
    }

    @Provides
    @Singleton
    fun provideDbManager(dbManagerImpl: DbManagerImpl): DbManager {
        return dbManagerImpl
    }
}