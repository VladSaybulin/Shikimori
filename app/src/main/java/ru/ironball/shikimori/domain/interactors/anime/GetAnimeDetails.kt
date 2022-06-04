package ru.ironball.shikimori.domain.interactors.anime

import ru.ironball.shikimori.domain.entities.anime.AnimeDetails
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetAnimeDetails @Inject constructor(private val repository: AnimeRepository) :
    Interactor<AnimeDetails, GetAnimeDetails.Params> {

    override suspend fun execute(params: Params): AnimeDetails {
        return repository.getDetails(params.animeId)
    }

    class Params(val animeId: Long)
}