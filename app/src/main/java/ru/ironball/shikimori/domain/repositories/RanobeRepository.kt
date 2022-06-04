package ru.ironball.shikimori.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.entities.manga.MangaDetails

interface RanobeRepository {

    suspend fun getRanobePaging(filters: Map<String, String>): Flow<PagingData<Manga>>

    suspend fun getDetails(mangaId: Long): MangaDetails

    suspend fun getRoles(mangaId: Long): Roles

    suspend fun getSimilar(mangaId: Long): List<Manga>
}