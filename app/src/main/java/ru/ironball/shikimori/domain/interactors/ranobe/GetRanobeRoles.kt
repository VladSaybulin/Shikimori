package ru.ironball.shikimori.domain.interactors.ranobe

import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.RanobeRepository
import javax.inject.Inject

class GetRanobeRoles @Inject constructor(private val repository: RanobeRepository) :
    Interactor<Roles, GetRanobeRoles.Params> {

    override suspend fun execute(params: Params): Roles {
        return repository.getRoles(params.ranobeId)
    }

    class Params(val ranobeId: Long)
}