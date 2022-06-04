package ru.ironball.shikimori.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ironball.shikimori.BuildConfig
import ru.ironball.shikimori.utils.network.UserAgentInterceptor
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideUserAgentInterceptor(): UserAgentInterceptor {
        return UserAgentInterceptor("Shikimori/${BuildConfig.VERSION_NAME} ${System.getProperty("http.agent")}")
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(userAgentInterceptor: UserAgentInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(userAgentInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://shikimori.one/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}