package ru.ironball.shikimori.ui

import android.util.Log
import kotlin.text.StringBuilder

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object AnimeSearch : Screen(
        "anime?order={order}&kind={kind}&status={status}&season={season}&score={score}&duration={duration}&rating={rating}&studio={studio}&franchise={franchise}&censored={censored}&mylist={mylist}"
    ) {
        fun createRoute(
            order: String? = null,
            kind: String? = null,
            status: String? = null,
            season: String? = null,
            score: String? = null,
            duration: String? = null,
            rating: String? = null,
            studio: String? = null,
            franchise: String? = null,
            censored: String? = null,
            myList: String? = null
        ): String {
            val argsBuilder = ArgumentsBuilder("anime")
            order?.let { argsBuilder.appendArgument("order", it) }
            kind?.let { argsBuilder.appendArgument("kind", it) }
            status?.let { argsBuilder.appendArgument("status", it) }
            season?.let { argsBuilder.appendArgument("season", it) }
            score?.let { argsBuilder.appendArgument("score", it) }
            duration?.let { argsBuilder.appendArgument("duration", it) }
            rating?.let { argsBuilder.appendArgument("rating", it) }
            studio?.let { argsBuilder.appendArgument("studio", it) }
            franchise?.let { argsBuilder.appendArgument("franchise", it) }
            censored?.let { argsBuilder.appendArgument("season", it) }
            myList?.let { argsBuilder.appendArgument("myList", it) }
            return argsBuilder.toString()
        }
    }

    object AnimeDetails : Screen("anime/{id}") {
        fun createRoute(id: Long): String = "anime/$id"
    }

    object AnimeCharacters : Screen("anime/{id}/characters") {
        fun createRoute(id: Long): String = "anime/$id/characters"
    }

    object AnimeAuthors : Screen("anime/{id}/authors") {
        fun createRoute(id: Long): String = "anime/$id/authors"
    }

    object MangaSearch : Screen(
        "manga?order={order}&kind={kind}&status={status}&season={season}&score={score}&publisher={publisher}&franchise={franchise}&censored={censored}&mylist={mylist}"
    ) {
        fun createRoute(
            order: String? = null,
            kind: String? = null,
            status: String? = null,
            season: String? = null,
            score: String? = null,
            publisher: String? = null,
            franchise: String? = null,
            censored: String? = null,
            myList: String? = null
        ): String {
            val argsBuilder = ArgumentsBuilder("manga")
            order?.let { argsBuilder.appendArgument("order", it) }
            kind?.let { argsBuilder.appendArgument("kind", it) }
            status?.let { argsBuilder.appendArgument("status", it) }
            season?.let { argsBuilder.appendArgument("season", it) }
            score?.let { argsBuilder.appendArgument("score", it) }
            publisher?.let { argsBuilder.appendArgument("publisher", it) }
            franchise?.let { argsBuilder.appendArgument("franchise", it) }
            censored?.let { argsBuilder.appendArgument("season", it) }
            myList?.let { argsBuilder.appendArgument("myList", it) }
            return argsBuilder.toString()
        }
    }

    object MangaDetails : Screen("manga/{id}") {
        fun createRoute(id: Long): String = "manga/$id"
    }

    object MangaCharacters : Screen("manga/{id}/characters") {
        fun createRoute(id: Long): String = "manga/$id/characters"
    }

    object MangaAuthors : Screen("manga/{id}/authors") {
        fun createRoute(id: Long): String = "manga/$id/authors"
    }

    object RanobeSearch : Screen(
        "ranobe?order={order}&kind={kind}&status={status}&season={season}&score={score}&publisher={publisher}&franchise={franchise}&censored={censored}&mylist={mylist}"
    ) {
        fun createRoute(
            order: String? = null,
            kind: String? = null,
            status: String? = null,
            season: String? = null,
            score: String? = null,
            publisher: String? = null,
            franchise: String? = null,
            censored: String? = null,
            myList: String? = null
        ): String {
            val argsBuilder = ArgumentsBuilder("ranobe")
            order?.let { argsBuilder.appendArgument("order", it) }
            kind?.let { argsBuilder.appendArgument("kind", it) }
            status?.let { argsBuilder.appendArgument("status", it) }
            season?.let { argsBuilder.appendArgument("season", it) }
            score?.let { argsBuilder.appendArgument("score", it) }
            publisher?.let { argsBuilder.appendArgument("publisher", it) }
            franchise?.let { argsBuilder.appendArgument("franchise", it) }
            censored?.let { argsBuilder.appendArgument("season", it) }
            myList?.let { argsBuilder.appendArgument("myList", it) }
            return argsBuilder.toString()
        }
    }

    object RanobeDetails : Screen("ranobe/{id}") {
        fun createRoute(id: Long): String = "ranobe/$id"
    }

    object RanobeCharacters : Screen("ranobe/{id}/characters") {
        fun createRoute(id: Long): String = "ranobe/$id/characters"
    }

    object RanobeAuthors : Screen("ranobe/{id}/authors") {
        fun createRoute(id: Long): String = "ranobe/$id/authors"
    }


}

private class ArgumentsBuilder(base: String) {

    private val stringBuilder = StringBuilder()

    init {
        stringBuilder.append(base)
    }

    private var count = 0

    fun appendArgument(name: String, value: String) {
        stringBuilder
            .append(if (count == 0) "?" else "&")
            .append(name).append("=").append(value)
    }

    override fun toString(): String = stringBuilder.toString()

}