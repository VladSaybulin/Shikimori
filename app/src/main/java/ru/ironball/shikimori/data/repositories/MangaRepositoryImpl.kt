package ru.ironball.shikimori.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.data.network.MangaApi
import ru.ironball.shikimori.data.network.MangaPagingSource
import ru.ironball.shikimori.data.entities.common.mappers.toRoles
import ru.ironball.shikimori.data.entities.manga.mappers.toManga
import ru.ironball.shikimori.data.entities.manga.mappers.toMangaDetails
import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.entities.manga.MangaDetails
import ru.ironball.shikimori.domain.repositories.MangaRepository
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    private val api: MangaApi,
    private val mangaPagingSourceFactory: MangaPagingSource.Factory,
) : MangaRepository {

    override suspend fun getMangaPaging(filters: Map<String, String>): Flow<PagingData<Manga>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                initialLoadSize = 50,
            ),
            pagingSourceFactory = { mangaPagingSourceFactory.create(filters) }
        ).flow
    }

    override suspend fun getDetails(mangaId: Long): MangaDetails {
        return api.getDetails(mangaId).toMangaDetails()
    }

    override suspend fun getRoles(mangaId: Long): Roles {
        return api.getRoles(mangaId).toRoles()
    }

    override suspend fun getSimilar(mangaId: Long): List<Manga> {
        return api.getSimilar(mangaId).map { it.toManga() }
    }
}