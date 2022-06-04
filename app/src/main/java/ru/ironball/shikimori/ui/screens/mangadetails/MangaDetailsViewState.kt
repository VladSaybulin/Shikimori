package ru.ironball.shikimori.ui.screens.mangadetails

import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.entities.manga.MangaDetails

sealed class MangaDetailsViewState {
    object Loading : MangaDetailsViewState()
    object Error : MangaDetailsViewState()

    class Show(
        val manga: MangaDetails,
        val roles: Roles,
        val similar: List<Manga>
    ) : MangaDetailsViewState()
}