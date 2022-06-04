package ru.ironball.shikimori.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.ironball.shikimori.data.entities.common.RolesResponse
import ru.ironball.shikimori.data.entities.manga.MangaDetailsResponse
import ru.ironball.shikimori.data.entities.manga.MangaResponse

interface MangaApi {

    @GET("/api/mangas")
    suspend fun getList(
        @Query("page") page: Int,
        @Query("limit") pageSize: Int,
        @QueryMap filters: Map<String, String>
    ): Response<List<MangaResponse>>

    @GET("api/mangas/{id}")
    suspend fun getDetails(@Path("id") id: Long): MangaDetailsResponse

    @GET("api/mangas/{id}/roles")
    suspend fun getRoles(@Path("id") id: Long): List<RolesResponse>

    @GET("api/mangas/{id}/similar")
    suspend fun getSimilar(@Path("id") id: Long): List<MangaResponse>
}