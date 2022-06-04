package ru.ironball.shikimori.data.entities.common.mappers

import ru.ironball.shikimori.data.entities.common.ImageResponse
import ru.ironball.shikimori.domain.entities.common.Image

fun ImageResponse.toImage(): Image {
    return Image(
        original,
        preview,
        x96,
        x48
    )
}