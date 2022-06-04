package ru.ironball.shikimori.data.mappers

import ru.ironball.shikimori.data.entities.anime.VideoResponse
import ru.ironball.shikimori.domain.entities.anime.Video

fun VideoResponse.toVideo(): Video {
    return Video(
        id = id,
        url = url,
        playerUrl = playerUrl,
        name = name,
        kind = kind,
        hosting = hosting,
    )
}