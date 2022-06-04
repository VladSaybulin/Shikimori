package ru.ironball.shikimori.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import ru.ironball.shikimori.data.entities.manga.mappers.toManga
import ru.ironball.shikimori.domain.entities.manga.Manga

class RanobePagingSource @AssistedInject constructor(
    private val api: RanobeApi,
    @Assisted private val filters: Map<String, String>,
) : PagingSource<Int, Manga>() {

    @AssistedFactory
    interface Factory {
        fun create(@Assisted filters: Map<String, String>): RanobePagingSource
    }

    override fun getRefreshKey(state: PagingState<Int, Manga>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Manga> {
        try {
            val pageNumber = params.key ?: 1
            val pageSize = params.loadSize.coerceAtMost(AnimeApi.MAX_PAGE_SIZE)
            val response = api.getList(pageNumber, pageSize, filters)

            if (response.isSuccessful) {
                val ranobes = response.body()!!.map { it.toManga() }
                val nextPageNumber = if (ranobes.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                return LoadResult.Page(
                    ranobes,
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
