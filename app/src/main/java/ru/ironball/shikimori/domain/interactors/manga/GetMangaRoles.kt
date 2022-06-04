package ru.ironball.shikimori.domain.interactors.manga

import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.MangaRepository
import javax.inject.Inject

class GetMangaRoles @Inject constructor(private val repository: MangaRepository) :
    Interactor<Roles, GetMangaRoles.Params> {

    override suspend fun execute(params: Params): Roles {
        return repository.getRoles(params.mangaId)
    }

    class Params(val mangaId: Long)
}