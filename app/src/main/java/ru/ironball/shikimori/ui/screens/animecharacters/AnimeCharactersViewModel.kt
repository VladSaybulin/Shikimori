package ru.ironball.shikimori.ui.screens.animecharacters

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.ironball.shikimori.domain.interactors.anime.GetAnimeRoles
import ru.ironball.shikimori.ui.common.characters.CharactersViewState
import javax.inject.Inject

@HiltViewModel
class AnimeCharactersViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAnimeRoles: GetAnimeRoles,
) : ViewModel() {
    private val id = savedStateHandle.get<String>("id")!!.toLong()

    private val _viewState =
        MutableStateFlow<CharactersViewState>(CharactersViewState.Loading)
    val viewState: Flow<CharactersViewState> = _viewState

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            val persons = getAnimeRoles.execute(GetAnimeRoles.Params(id))
            _viewState.tryEmit(
                CharactersViewState.Show(
                    persons.mainCharacters,
                    persons.minorCharacters
                )
            )
        }
    }
}