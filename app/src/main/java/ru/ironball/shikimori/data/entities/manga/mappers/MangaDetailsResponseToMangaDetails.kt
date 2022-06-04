package ru.ironball.shikimori.data.entities.manga.mappers

import ru.ironball.shikimori.data.entities.common.mappers.toGenre
import ru.ironball.shikimori.data.entities.common.mappers.toImage
import ru.ironball.shikimori.data.entities.common.mappers.toStatistic
import ru.ironball.shikimori.data.entities.manga.MangaDetailsResponse
import ru.ironball.shikimori.domain.entities.manga.MangaDetails
import ru.ironball.shikimori.domain.entities.manga.MangaKind

fun MangaDetailsResponse.toMangaDetails(): MangaDetails {
    return MangaDetails(
        id = id,
        name = name,
        russianName = russianName.ifEmpty { null },
        image = image.toImage(),
        url = url,
        kind = kind ?: MangaKind.NONE,
        status = status,
        score = score,
        volumes = volumes,
        chapters = chapters,
        dateAired = dateAired,
        dateReleased = dateReleased,
        englishNames = englishNames?.filterNotNull()?.ifEmpty { null },
        japaneseNames = japaneseNames?.filterNotNull()?.ifEmpty { null },
        synonymNames = synonymsNames,
        licenseName = licenseName,
        description = description,
        descriptionHtml = descriptionHtml,
        descriptionSource = descriptionSource,
        franchise = franchise,
        isFavorite = favoured,
        genres = genres.map { it.toGenre() },
        publishers = publishers.map { it.toPublisher() },
        threadId = threadId,
        topicId = topicId,
        rateScoreStats = ratesScoresStats.map { it.toStatistic() },
        rateStatusStats = ratesStatusesStats.map { it.toStatistic() },
    )
}