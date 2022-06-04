package ru.ironball.shikimori.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.ironball.shikimori.data.network.AnimeApi
import ru.ironball.shikimori.data.network.GenresApi
import ru.ironball.shikimori.data.network.MangaApi
import ru.ironball.shikimori.data.network.RanobeApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideAnimeApi(retrofit: Retrofit): AnimeApi {
        return retrofit.create(AnimeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMangaApi(retrofit: Retrofit): MangaApi {
        return retrofit.create(MangaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRanobeApi(retrofit: Retrofit): RanobeApi {
        return retrofit.create(RanobeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGenresApi(retrofit: Retrofit): GenresApi {
        return retrofit.create(GenresApi::class.java)
    }

}