package ru.ironball.shikimori.domain.interactors.ranobe

import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.RanobeRepository
import javax.inject.Inject

class GetSimilarRanobe @Inject constructor(private val repository: RanobeRepository) :
    Interactor<List<Manga>, GetSimilarRanobe.Params> {

    override suspend fun execute(params: Params): List<Manga> {
        return repository.getSimilar(params.ranobeid)
    }

    class Params(val ranobeid: Long)
}