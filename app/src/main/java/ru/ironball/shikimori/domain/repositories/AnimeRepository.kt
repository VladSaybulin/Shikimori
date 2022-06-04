package ru.ironball.shikimori.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.anime.AnimeDetails
import ru.ironball.shikimori.domain.entities.common.Roles

interface AnimeRepository {
    @Deprecated("use getAnimePaging")
    fun getList(filters: Map<String, String>): List<Anime>

    suspend fun getAnimePaging(filters: Map<String, String>): Flow<PagingData<Anime>>

    suspend fun getDetails(animeId: Long): AnimeDetails

    suspend fun getRoles(animeId: Long): Roles

    suspend fun getSimilar(animeId: Long): List<Anime>
}