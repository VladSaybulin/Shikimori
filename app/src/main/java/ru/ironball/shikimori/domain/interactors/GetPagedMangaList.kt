package ru.ironball.shikimori.domain.interactors

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.repositories.MangaRepository
import javax.inject.Inject


class GetPagedMangaList @Inject constructor(
    private val mangaRepository: MangaRepository
): Interactor<Flow<PagingData<Manga>>, GetPagedMangaList.Params> {

    class Params(val filters: Map<String, String>)

    override suspend fun execute(params: Params): Flow<PagingData<Manga>> {
        return mangaRepository.getMangaPaging(params.filters)
    }
}