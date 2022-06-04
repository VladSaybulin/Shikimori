package ru.ironball.shikimori.data.entities.anime.mappers

import ru.ironball.shikimori.data.entities.anime.AnimeDetailsResponse
import ru.ironball.shikimori.data.entities.common.mappers.toGenre
import ru.ironball.shikimori.data.entities.common.mappers.toImage
import ru.ironball.shikimori.data.entities.common.mappers.toStatistic
import ru.ironball.shikimori.data.mappers.toScreenshot
import ru.ironball.shikimori.data.mappers.toStudio
import ru.ironball.shikimori.data.mappers.toVideo
import ru.ironball.shikimori.domain.entities.anime.AnimeDetails
import ru.ironball.shikimori.domain.entities.anime.AnimeKind

fun AnimeDetailsResponse.toAnimeDetails(): AnimeDetails {
    return AnimeDetails(
        id = id,
        name = name,
        russianName = russianName.ifEmpty { null },
        image = image.toImage(),
        url = url,
        kind = kind ?: AnimeKind.NONE,
        status = status,
        score = score,
        episodes = episodes,
        episodesAired = episodesAired,
        dateAired = dateAired,
        dateReleased = dateReleased,
        ageRating = ageRating,
        dateNextEpisode = dateNextEpisode,
        englishNames = englishNames?.filterNotNull()?.ifEmpty { null },
        japaneseNames = japaneseNames?.filterNotNull()?.ifEmpty { null },
        synonymNames = synonymsNames,
        licenseName = licenseName,
        duration = duration,
        description = description,
        descriptionHtml = descriptionHtml,
        descriptionSource = descriptionSource,
        franchise = franchise,
        isFavorite = favoured,
        genres = genres.map { it.toGenre() },
        studios = studios.map { it.toStudio() },
        threadId = threadId,
        topicId = topicId,
        rateScoreStats = ratesScoresStats.map { it.toStatistic() },
        rateStatusStats = ratesStatusesStats.map { it.toStatistic() },
        videos = videos.map { it.toVideo() },
        screenshots = screenshots.map { it.toScreenshot() },
        licensors = licensors,
        subbers = subbers,
        dubbers = dubbers,
    )
}