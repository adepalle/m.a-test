package fr.adepalle.data.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.adepalle.data.manager.api.service.UserTaskServiceApi
import fr.adepalle.domain.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    /**
     * Retrofit is a heavy object, so we put it as a Singleton to prevent re-creation
     */
    @Provides
    @Singleton
    fun retrofitService(
        okHttpClient: OkHttpClient,
        callAdapterFactory: CallAdapter.Factory,
        converter: Converter.Factory
    ): UserTaskServiceApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapterFactory)
            .addConverterFactory(converter)
            .build()
            .create(UserTaskServiceApi::class.java)

    /**
     * Retrofit Client
     */
    @Provides
    @Reusable
    fun provideApiOkHttp(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    /**
     * Retrofit Adapter
     */
    @Provides
    @Reusable
    fun provideRxCallAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    /**
     * Retrofit Converter
     */
    @Provides
    @Reusable
    fun provideGsonConverter(): Converter.Factory =
        GsonConverterFactory.create(
            GsonBuilder().create()
        )

    /**
     * OkHttp Interceptor
     */
    @Provides
    @Reusable
    fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
}