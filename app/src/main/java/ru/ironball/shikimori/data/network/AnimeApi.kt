package ru.ironball.shikimori.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.ironball.shikimori.data.entities.anime.AnimeDetailsResponse
import ru.ironball.shikimori.data.entities.anime.AnimeResponse
import ru.ironball.shikimori.data.entities.common.RolesResponse

interface AnimeApi {

    companion object {
        const val MAX_PAGE_SIZE = 50
    }

    @GET("/api/animes")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("limit") pageSize: Int,
        @QueryMap filters: Map<String, String>,
    ): Response<List<AnimeResponse>>

    @GET("api/animes/{id}")
    suspend fun getDetails(@Path("id") id: Long): AnimeDetailsResponse

    @GET("api/animes/{id}/roles")
    suspend fun getRoles(@Path("id") id: Long): List<RolesResponse>

    @GET("api/animes/{id}/similar")
    suspend fun getSimilar(@Path("id") id: Long): List<AnimeResponse>
}