package ru.ironball.shikimori.ui.screens.ranobesearch

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.ironball.shikimori.domain.entities.manga.Manga
import ru.ironball.shikimori.domain.interactors.GetPagedMangaList
import ru.ironball.shikimori.domain.interactors.GetPagedRanobeList
import javax.inject.Inject

@HiltViewModel
class RanobeSearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPagedRanobeList: GetPagedRanobeList,
) : ViewModel() {

    private val appliedFilters = MutableStateFlow(
        mutableMapOf<String, String>().apply {
            put("order", savedStateHandle.get<String>("order")!!)
            savedStateHandle.get<String>("kind")?.let { put("kind", it) }
        }
    )

    private val _query = MutableStateFlow("")
    val query: Flow<String> = _query

    var pagedRanobeList: Flow<PagingData<Manga>> =
        combine(
            appliedFilters,
            _query.debounce(500)
        ) { appliedFilters, query ->
            appliedFilters["search"] = query
            appliedFilters
        }.flatMapLatest {
            getPagedRanobeList.execute(GetPagedRanobeList.Params(it))
        }.cachedIn(viewModelScope)

    fun search(search: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _query.emit(search)
        }
    }

}