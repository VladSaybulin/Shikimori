package ru.ironball.shikimori.domain.interactors.ranobe

import ru.ironball.shikimori.domain.entities.manga.MangaDetails
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.RanobeRepository
import javax.inject.Inject

class GetRanobeDetails @Inject constructor(private val repository: RanobeRepository) :
    Interactor<MangaDetails, GetRanobeDetails.Params> {

    override suspend fun execute(params: Params): MangaDetails {
        return repository.getDetails(params.ranobeId)
    }

    class Params(val ranobeId: Long)
}