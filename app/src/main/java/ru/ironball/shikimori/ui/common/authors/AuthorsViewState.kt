package ru.ironball.shikimori.ui.common.authors

import ru.ironball.shikimori.domain.entities.person.PersonWithRoles

sealed class AuthorsViewState {
    object Loading : AuthorsViewState()
    object Error : AuthorsViewState()
    class Show(val authors: List<PersonWithRoles>) : AuthorsViewState()
}