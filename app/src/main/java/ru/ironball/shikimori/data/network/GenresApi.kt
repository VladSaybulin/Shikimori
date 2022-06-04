package ru.ironball.shikimori.data.network

import retrofit2.http.GET
import ru.ironball.shikimori.data.entities.common.GenreResponse

interface GenresApi {

    @GET("/api/genres")
    fun getList(): List<GenreResponse>

}