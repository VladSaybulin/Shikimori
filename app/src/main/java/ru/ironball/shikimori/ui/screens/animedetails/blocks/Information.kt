package ru.ironball.shikimori.ui.screens.animedetails.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.anime.AnimeKind
import ru.ironball.shikimori.domain.entities.anime.AnimeStatus
import ru.ironball.shikimori.domain.entities.common.AgeRating
import ru.ironball.shikimori.domain.entities.common.Genre
import ru.ironball.shikimori.ui.components.Block
import ru.ironball.shikimori.ui.common.stringAgeRating
import ru.ironball.shikimori.ui.common.stringAnimeKind
import ru.ironball.shikimori.ui.components.SimpleValueText
import ru.ironball.shikimori.ui.theme.AppTheme
import ru.ironball.shikimori.utils.fullFormatter
import ru.ironball.shikimori.utils.yearOnlyFormatter
import java.util.*

@Composable
fun InformationBlock(
    kind: AnimeKind,
    episodes: Int,
    episodesAired: Int,
    durationEpisode: Int,
    status: AnimeStatus,
    dateAired: Date?,
    dateReleased: Date?,
    genres: List<Genre>,
    ageRating: AgeRating,
) {

    val valueSpanStyle = LocalTextStyle.current.toSpanStyle()
    val titleSpanStyle = valueSpanStyle.copy(color = valueSpanStyle.color.copy(alpha = 0.4f))

    val stringGenres = remember { genres.joinToString(", ") { it.russianOrOriginalName } }

    Block(title = stringResource(id = R.string.block_title_information)) {
        Column(Modifier.padding(it), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            stringAnimeKind(kind = kind)?.let { value ->
                SimpleValueText(
                    title = stringResource(id = R.string.kind),
                    value = value,
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }

            buildStringEpisodes(episodes, episodesAired, status)?.let { value ->
                SimpleValueText(
                    title = stringResource(id = R.string.episodes),
                    value = value,
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }

            if (durationEpisode > 0) {
                SimpleValueText(
                    title = stringResource(id = R.string.duration),
                    value = "$durationEpisode ??????.",
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }

            buildStringStatus(
                status = status,
                airedDate = dateAired,
                releasedDate = dateReleased,
                defaultSpanStyle = valueSpanStyle
            )?.let { value ->
                SimpleValueText(
                    title = stringResource(id = R.string.status),
                    value = value,
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }

            if (genres.isNotEmpty()) {
                SimpleValueText(
                    title = stringResource(id = R.string.genres),
                    value = stringGenres,
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }

            stringAgeRating(ageRating = ageRating)?.let { value ->
                SimpleValueText(
                    title = stringResource(id = R.string.age_rating),
                    value = value,
                    titleSpanStyle = titleSpanStyle,
                    valueSpanStyle = valueSpanStyle,
                )
            }
        }
    }
}

@Composable
@ReadOnlyComposable
private fun buildStringStatus(
    status: AnimeStatus,
    airedDate: Date?,
    releasedDate: Date?,
    defaultSpanStyle: SpanStyle,
): AnnotatedString? {

    return when (status) {
        AnimeStatus.ANONS -> {
            return buildAnnotatedString {
                withStyle(
                    defaultSpanStyle.copy(
                        color = Color.White,
                        background = AppTheme.colors.anonsColor,
                        fontWeight = FontWeight.W500,
                    )
                ) {
                    append("  ${stringResource(id = R.string.status_anons)}  ")
                }
                airedDate?.let {
                    append(" ???? ")
                    append(yearOnlyFormatter.format(it))
                    append(" ??????")
                }
            }
        }
        AnimeStatus.ONGOING -> {
            return buildAnnotatedString {
                withStyle(
                    defaultSpanStyle.copy(
                        color = Color.White,
                        background = AppTheme.colors.ongoingColor,
                        fontWeight = FontWeight.W500,
                    )
                ) {
                    append("  ${stringResource(id = R.string.status_ongoing)}  ")
                }
                airedDate?.let {
                    append(" ?? ")
                    append(fullFormatter.format(it))
                }
                releasedDate?.let {
                    append(" ???? ")
                    append(fullFormatter.format(it))
                }
            }
        }
        AnimeStatus.RELEASED -> {
            return buildAnnotatedString {
                withStyle(
                    defaultSpanStyle.copy(
                        color = Color.White,
                        background = AppTheme.colors.releasedColor,
                        fontWeight = FontWeight.W500,
                    )
                ) {
                    append("  ${stringResource(id = R.string.status_released)}  ")
                }
                airedDate?.let {
                    append(" ?? ")
                    append(fullFormatter.format(it))
                }
                releasedDate?.let {
                    append(" ???? ")
                    append(fullFormatter.format(it))
                }
            }
        }
        else -> null
    }
}

private fun buildStringEpisodes(episodes: Int, airedEpisodes: Int, status: AnimeStatus): String? {
    return if (status == AnimeStatus.ANONS || status == AnimeStatus.RELEASED) {
        if (episodes == 0) null else episodes.toString()
    } else {
        if (episodes <= 1 && airedEpisodes == 0) {
            null
        } else if (episodes == 0) {
            "$airedEpisodes/?"
        } else {
            "$airedEpisodes/$episodes"
        }
    }
}
