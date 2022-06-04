package ru.ironball.shikimori.ui.screens.mangadetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.ironball.shikimori.domain.interactors.manga.GetMangaDetails
import ru.ironball.shikimori.domain.interactors.manga.GetMangaRoles
import ru.ironball.shikimori.domain.interactors.manga.GetSimilarManga
import javax.inject.Inject

@HiltViewModel
class MangaDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMangaDetails: GetMangaDetails,
    private val getMangaRoles: GetMangaRoles,
    private val getSimilarManga: GetSimilarManga,
) : ViewModel() {

    val id: Long = savedStateHandle.get<String>("id")!!.toLong()

    private val _viewState = MutableStateFlow<MangaDetailsViewState>(MangaDetailsViewState.Loading)
    val viewState: Flow<MangaDetailsViewState> = _viewState

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val manga = getMangaDetails.execute(GetMangaDetails.Params(id))
                val roles = getMangaRoles.execute(GetMangaRoles.Params(id))
                val similar = getSimilarManga.execute(GetSimilarManga.Params(id))
                _viewState.value = MangaDetailsViewState.Show(manga, roles, similar)
            } catch (exception: HttpException) {
                _viewState.value = MangaDetailsViewState.Error
            }
        }
    }
}