package ru.ironball.shikimori.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import ru.ironball.shikimori.data.entities.anime.mappers.toAnime
import ru.ironball.shikimori.domain.entities.anime.Anime

class AnimePagingSource @AssistedInject constructor(
    private val api: AnimeApi,
    @Assisted private val filters: Map<String, String>,
) : PagingSource<Int, Anime>() {

    @AssistedFactory
    interface Factory {
        fun create(@Assisted filters: Map<String, String>): AnimePagingSource
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        try {
            val pageNumber = params.key ?: 1
            val pageSize = params.loadSize.coerceAtMost(AnimeApi.MAX_PAGE_SIZE)
            val response = api.getList(pageNumber, pageSize, filters)

            if (response.isSuccessful) {
                val animes = response.body()!!.map { it.toAnime() }
                val nextPageNumber = if (animes.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                return LoadResult.Page(
                    animes,
                    nextKey = nextPageNumber,
                    prevKey = prevPageNumber
                )
            } else {
                return LoadResult.Error(HttpException(response).apply { printStackTrace() })
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }

    }
}