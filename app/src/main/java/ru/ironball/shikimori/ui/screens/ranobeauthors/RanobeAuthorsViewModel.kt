package ru.ironball.shikimori.ui.screens.ranobeauthors

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.ironball.shikimori.domain.interactors.ranobe.GetRanobeRoles
import ru.ironball.shikimori.ui.common.authors.AuthorsViewState
import javax.inject.Inject

@HiltViewModel
class RanobeAuthorsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAnimeRoles: GetRanobeRoles,
) : ViewModel() {

    private val id = savedStateHandle.get<String>("id")!!.toLong()

    private val _viewState =
        MutableStateFlow<AuthorsViewState>(AuthorsViewState.Loading)
    val viewState: Flow<AuthorsViewState> = _viewState

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            val persons = getAnimeRoles.execute(GetRanobeRoles.Params(id))
            _viewState.tryEmit(
                AuthorsViewState.Show(persons.allAuthors)
            )
        }
    }

}