package ru.ironball.shikimori.domain.interactors.anime

import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.AnimeRepository
import javax.inject.Inject

class GetAnimeRoles @Inject constructor(private val repository: AnimeRepository) :
    Interactor<Roles, GetAnimeRoles.Params> {

    override suspend fun execute(params: Params): Roles {
        return repository.getRoles(params.animeId)
    }

    class Params(val animeId: Long)
}