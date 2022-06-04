package ru.ironball.shikimori.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ironball.shikimori.data.entities.common.mappers.toGenre
import ru.ironball.shikimori.data.network.GenresApi
import ru.ironball.shikimori.domain.entities.common.Genre
import ru.ironball.shikimori.domain.repositories.GenreRepository
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(private val api: GenresApi) : GenreRepository {

    private var animeGenres: List<Genre>? = null
    private var mangaGenres: List<Genre>? = null

    override suspend fun load() {
        withContext(Dispatchers.IO) {
            val genres = api.getList().map { it.toGenre() }
            animeGenres = genres.filter { it.kind == "anime" }
            mangaGenres = genres.filter { it.kind == "manga" }
        }
    }

    override fun getAnimeGenres(): List<Genre> = animeGenres ?: throw Exception("Genres not loaded")

    override fun getMangaGenres(): List<Genre> = mangaGenres ?: throw Exception("Genres not loaded")

}