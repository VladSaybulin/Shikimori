package ru.ironball.shikimori.ui.common.characters

import ru.ironball.shikimori.domain.entities.person.Person

sealed class CharactersViewState {
    object Loading : CharactersViewState()
    object Error : CharactersViewState()
    class Show(val main: List<Person>, val minor: List<Person>) : CharactersViewState()
}