package ru.ironball.shikimori.data.mappers

import ru.ironball.shikimori.data.entities.anime.ScreenshotResponse
import ru.ironball.shikimori.domain.entities.anime.Screenshot

fun ScreenshotResponse.toScreenshot(): Screenshot {
    return Screenshot(
        original = original,
        preview = preview,
    )
}