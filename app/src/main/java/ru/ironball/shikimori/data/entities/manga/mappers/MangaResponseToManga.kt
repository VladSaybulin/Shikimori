package ru.ironball.shikimori.data.entities.manga.mappers

import ru.ironball.shikimori.data.entities.common.mappers.toImage
import ru.ironball.shikimori.data.entities.manga.MangaResponse
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.entities.manga.MangaKind
import ru.ironball.shikimori.domain.entities.manga.MangaStatus
import java.util.*

fun MangaResponse.toManga(): Manga {
    return Manga(
        id = id,
        name = name,
        russianName = russianName.ifEmpty { null },
        image = image.toImage(),
        url = url,
        kind= kind ?: MangaKind.NONE,
        status = status ?: MangaStatus.NONE,
        score = score,
        volumes = volumes,
        chapters = chapters,
        dateAired =  dateAired?.let { Calendar.getInstance().apply { time = it } },
        dateReleased =  dateReleased?.let { Calendar.getInstance().apply { time = it } },
    )
}