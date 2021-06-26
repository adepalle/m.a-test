package fr.adepalle.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.adepalle.data.di.AppConstants.BASE_URL
import fr.adepalle.data.manager.api.ApiManager
import fr.adepalle.data.manager.api.ApiManagerImpl
import fr.adepalle.data.manager.api.service.TodosServiceApi
import fr.adepalle.data.repository.UserRepositoryImpl
import fr.adepalle.domain.repository.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryApi(retrofit: Retrofit): TodosServiceApi {
        return retrofit.create(TodosServiceApi::class.java)
    }

    @Singleton
    @Provides
    fun providesTodosRepository(todosRepository: UserRepositoryImpl): UserRepository {
        return todosRepository
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): OkHttpClient {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .addInterceptor(httpInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiManager(apiManagerImpl: ApiManagerImpl): ApiManager {
        return apiManagerImpl
    }
}