package ru.ironball.shikimori.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.data.entities.anime.mappers.toAnime
import ru.ironball.shikimori.data.entities.anime.mappers.toAnimeDetails
import ru.ironball.shikimori.data.entities.common.mappers.toRoles
import ru.ironball.shikimori.data.network.AnimeApi
import ru.ironball.shikimori.data.network.AnimePagingSource
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.anime.AnimeDetails
import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.repositories.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val api: AnimeApi,
    private val animePagingSourceFactory: AnimePagingSource.Factory,
) : AnimeRepository {

    @Deprecated("use getAnimePaging", ReplaceWith("listOf()"))
    override fun getList(filters: Map<String, String>): List<Anime> {
        return listOf()
    }

    override suspend fun getAnimePaging(filters: Map<String, String>): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                initialLoadSize = 50,
            ),
            pagingSourceFactory = { animePagingSourceFactory.create(filters) }
        ).flow
    }

    override suspend fun getDetails(animeId: Long): AnimeDetails {
        return api.getDetails(animeId).toAnimeDetails()
    }

    override suspend fun getRoles(animeId: Long): Roles {
        return api.getRoles(animeId).toRoles()
    }

    override suspend fun getSimilar(animeId: Long): List<Anime> {
        return api.getSimilar(animeId).map { it.toAnime() }
    }
}