package ru.ironball.shikimori.ui.screens.animedetails

import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.anime.AnimeDetails
import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.entities.person.Person

sealed class AnimeDetailsViewState {
    object Loading : AnimeDetailsViewState()
    object Error : AnimeDetailsViewState()

    class Show(
        val anime: AnimeDetails,
        val roles: Roles,
        val similarAnime: List<Anime>
    ) : AnimeDetailsViewState()
}