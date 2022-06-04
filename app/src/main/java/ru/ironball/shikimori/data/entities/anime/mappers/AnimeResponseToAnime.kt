package ru.ironball.shikimori.data.entities.anime.mappers

import ru.ironball.shikimori.data.entities.anime.AnimeResponse
import ru.ironball.shikimori.data.entities.common.mappers.toImage
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.anime.AnimeKind
import ru.ironball.shikimori.domain.entities.anime.AnimeStatus
import java.util.*

fun AnimeResponse.toAnime(): Anime {
    return Anime(
        id = id,
        name = name,
        russianName = russianName.ifEmpty { null },
        image = image.toImage(),
        url = url,
        kind = kind ?: AnimeKind.NONE,
        status = status ?: AnimeStatus.NONE,
        score = score,
        episodes = episodes,
        episodesAired = airedEpisodes,
        dateAired = dateAired?.let { Calendar.getInstance().apply { time = it } },
        dateReleased = dateReleased?.let { Calendar.getInstance().apply { time = it } },
    )
}