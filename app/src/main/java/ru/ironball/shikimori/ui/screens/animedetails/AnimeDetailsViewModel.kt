package ru.ironball.shikimori.ui.screens.animedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.ironball.shikimori.domain.interactors.anime.GetAnimeDetails
import ru.ironball.shikimori.domain.interactors.anime.GetAnimeRoles
import ru.ironball.shikimori.domain.interactors.anime.GetSimilarAnime
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAnimeDetails: GetAnimeDetails,
    private val getAnimeRoles: GetAnimeRoles,
    private val getSimilarAnime: GetSimilarAnime
) : ViewModel() {

    val id: Long = savedStateHandle.get<String>("id")!!.toLong()

    private val _viewState = MutableStateFlow<AnimeDetailsViewState>(AnimeDetailsViewState.Loading)
    val viewState: Flow<AnimeDetailsViewState> = _viewState

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val anime = getAnimeDetails.execute(GetAnimeDetails.Params(id))
                val roles = getAnimeRoles.execute(GetAnimeRoles.Params(id))
                val similarAnime = getSimilarAnime.execute(GetAnimeRoles.Params(id))
                _viewState.value = AnimeDetailsViewState.Show(anime, roles, similarAnime)
            } catch (exception: HttpException) {
                _viewState.value = AnimeDetailsViewState.Error
            }
        }
    }
}