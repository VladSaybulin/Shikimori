package ru.ironball.shikimori.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.ironball.shikimori.R
import ru.ironball.shikimori.domain.entities.anime.AnimeKind
import ru.ironball.shikimori.domain.entities.anime.AnimeStatus
import ru.ironball.shikimori.domain.entities.common.AgeRating
import ru.ironball.shikimori.domain.entities.manga.MangaKind

@Composable
fun getMangaKindString(kind: MangaKind) = stringResource(
    id = when (kind) {
        MangaKind.MANGA -> R.string.manga_kind_manga
        MangaKind.MANHUA -> R.string.manga_kind_manhua
        MangaKind.MANHWA -> R.string.manga_kind_manhwa
        MangaKind.DOUJIN -> R.string.manga_kind_doujin
        MangaKind.NOVEL -> R.string.ranobe_kind_novel
        MangaKind.RANOBE -> R.string.ranobe_kind_ranobe
        else -> R.string.kind_none
    }
)

@Composable
fun stringByAnimeStatus(status: AnimeStatus): String? {
    return when(status) {
        AnimeStatus.ANONS -> stringResource(R.string.status_anons)
        AnimeStatus.ONGOING -> stringResource(R.string.status_ongoing)
        AnimeStatus.RELEASED -> stringResource(R.string.status_released)
        else -> null
    }
}

@Composable
fun stringAnimeKind(kind: AnimeKind): String? {
    return when(kind) {
        AnimeKind.TV -> stringResource(R.string.anime_kind_tv)
        AnimeKind.MOVIE -> stringResource(R.string.anime_kind_movie)
        AnimeKind.SPECIAL -> stringResource(R.string.anime_kind_special)
        AnimeKind.OVA -> stringResource(R.string.anime_kind_ova)
        AnimeKind.ONA -> stringResource(R.string.anime_kind_ona)
        AnimeKind.MUSIC -> stringResource(R.string.anime_kind_music)
        else -> null
    }
}

@Composable
fun stringByAnimeKind(kind: AnimeKind) = stringResource(
    id = when (kind) {
        AnimeKind.TV -> R.string.anime_kind_tv
        AnimeKind.MOVIE -> R.string.anime_kind_movie
        AnimeKind.SPECIAL -> R.string.anime_kind_special
        AnimeKind.OVA -> R.string.anime_kind_ova
        AnimeKind.ONA -> R.string.anime_kind_ona
        AnimeKind.MUSIC -> R.string.anime_kind_music
        else -> R.string.kind_none
    }
)

@Composable
fun stringMangaKind(kind: MangaKind): String? {
    return when (kind) {
        MangaKind.MANGA -> stringResource(R.string.manga_kind_manga)
        MangaKind.MANHUA -> stringResource(R.string.manga_kind_manhua)
        MangaKind.MANHWA -> stringResource(R.string.manga_kind_manhwa)
        MangaKind.DOUJIN -> stringResource(R.string.manga_kind_doujin)
        MangaKind.NOVEL -> stringResource(R.string.ranobe_kind_novel)
        MangaKind.RANOBE -> stringResource(R.string.ranobe_kind_ranobe)
        MangaKind.ONE_SHOT -> stringResource(R.string.manga_kind_one_shot)
        else -> null
    }
}

@Composable
fun stringAgeRating(ageRating: AgeRating): String? {
    return when(ageRating) {
        AgeRating.R17 -> stringResource(R.string.age_rating_r_17)
        AgeRating.G -> stringResource(R.string.age_rating_g)
        AgeRating.PG -> stringResource(R.string.age_rating_pg)
        AgeRating.PG_13 -> stringResource(R.string.age_rating_pg_13)
        AgeRating.RX -> stringResource(R.string.age_rating_rx)
        AgeRating.R_PLUS -> stringResource(R.string.age_rating_r_plus)
        else -> null
    }
}