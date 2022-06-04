package ru.ironball.shikimori.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ironball.shikimori.data.repositories.*
import ru.ironball.shikimori.domain.repositories.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAnimeRepository(animeRepository: AnimeRepositoryImpl) : AnimeRepository

    @Singleton
    @Binds
    abstract fun bindMangaRepository(mangaRepository: MangaRepositoryImpl) : MangaRepository

    @Singleton
    @Binds
    abstract fun bindRanobeRepository(ranobeRepository: RanobeRepositoryImpl) : RanobeRepository

    @Singleton
    @Binds
    abstract fun bindGenreRepository(genreRepository: GenreRepositoryImpl) : GenreRepository



}