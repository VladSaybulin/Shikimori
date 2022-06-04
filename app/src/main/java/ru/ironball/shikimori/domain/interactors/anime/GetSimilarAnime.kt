package ru.ironball.shikimori.domain.interactors.anime

import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetSimilarAnime @Inject constructor(private val repository: AnimeRepository) :
    Interactor<List<Anime>, GetAnimeRoles.Params> {

    override suspend fun execute(params: GetAnimeRoles.Params): List<Anime> {
        return repository.getSimilar(params.animeId)
    }

    class Params(val animeId: Long)
}