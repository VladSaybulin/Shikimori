package ru.ironball.shikimori.domain.interactors

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.repositories.AnimeRepository

import javax.inject.Inject

class GetPagedAnimeList @Inject constructor(
    private val animeRepository: AnimeRepository
) : Interactor<Flow<PagingData<Anime>>, GetPagedAnimeList.Params> {

    class Params(val filters: Map<String, String>)

    override suspend fun execute(params: Params): Flow<PagingData<Anime>> {
        return animeRepository.getAnimePaging(params.filters)
    }
}