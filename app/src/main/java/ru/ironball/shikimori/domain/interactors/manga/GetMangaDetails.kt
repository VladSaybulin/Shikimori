package ru.ironball.shikimori.domain.interactors.manga

import ru.ironball.shikimori.domain.entities.manga.MangaDetails
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.MangaRepository
import javax.inject.Inject

class GetMangaDetails @Inject constructor(private val repository: MangaRepository) :
    Interactor<MangaDetails, GetMangaDetails.Params> {

    override suspend fun execute(params: Params): MangaDetails {
        return repository.getDetails(params.mangaId)
    }

    class Params(val mangaId: Long)
}