package ru.ironball.shikimori.ui.screens.mangasearch

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.ironball.shikimori.domain.entities.anime.Anime
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.interactors.GetPagedAnimeList
import ru.ironball.shikimori.domain.interactors.GetPagedMangaList
import javax.inject.Inject

@HiltViewModel
class MangaSearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPagedAnimeList: GetPagedMangaList,
) : ViewModel() {

    private val appliedFilters = MutableStateFlow(
        mutableMapOf<String, String>().apply {
            put("order", savedStateHandle.get<String>("order")!!)
            savedStateHandle.get<String>("kind")?.let { put("kind", it) }
        }
    )

    private val _query = MutableStateFlow("")
    val query: Flow<String> = _query

    var pagedMangaList: Flow<PagingData<Manga>> =
        combine(
            appliedFilters,
            _query.debounce(500)
        ) { appliedFilters, query ->
            appliedFilters["search"] = query
            appliedFilters
        }.flatMapLatest {
            getPagedAnimeList.execute(GetPagedMangaList.Params(it))
        }.cachedIn(viewModelScope)

    fun search(search: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _query.emit(search)
        }
    }

}