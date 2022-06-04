package ru.ironball.shikimori.data.entities.common.mappers

import ru.ironball.shikimori.data.entities.common.GenreResponse
import ru.ironball.shikimori.domain.entities.common.Genre

fun GenreResponse.toGenre(): Genre {
    return Genre(
        id = id,
        name = name,
        russianName = russianName,
        kind = kind,
    )
}