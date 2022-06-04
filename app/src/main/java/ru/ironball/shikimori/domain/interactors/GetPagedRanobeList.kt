package ru.ironball.shikimori.domain.interactors

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.repositories.RanobeRepository
import javax.inject.Inject

class GetPagedRanobeList @Inject constructor(
    private val ranobeRepository: RanobeRepository
): Interactor<Flow<PagingData<Manga>>, GetPagedRanobeList.Params> {

    class Params(val filters: Map<String, String>)

    override suspend fun execute(params: Params): Flow<PagingData<Manga>> {
        return ranobeRepository.getRanobePaging(params.filters)
    }
}