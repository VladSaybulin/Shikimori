package ru.ironball.shikimori.domain.interactors.manga

import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.interactors.Interactor
import ru.ironball.shikimori.domain.repositories.MangaRepository
import javax.inject.Inject


class GetSimilarManga @Inject constructor(private val repository: MangaRepository) :
    Interactor<List<Manga>, GetSimilarManga.Params> {

    override suspend fun execute(params: Params): List<Manga> {
        return repository.getSimilar(params.mangaId)
    }

    class Params(val mangaId: Long)
}