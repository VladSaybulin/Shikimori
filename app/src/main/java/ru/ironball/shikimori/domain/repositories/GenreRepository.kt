package ru.ironball.shikimori.domain.repositories

import ru.ironball.shikimori.domain.entities.common.Genre

interface GenreRepository {
    suspend fun load()

    fun getAnimeGenres(): List<Genre>

    fun getMangaGenres(): List<Genre>
}