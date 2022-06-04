package ru.ironball.shikimori.data.mappers

import ru.ironball.shikimori.data.entities.anime.StudioResponse
import ru.ironball.shikimori.domain.entities.anime.Studio

fun StudioResponse.toStudio(): Studio {
    return Studio(
        id = id,
        name = name,
        filteredName = filteredName,
        real = real,
        image = image
    )
}