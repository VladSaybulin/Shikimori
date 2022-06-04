package ru.ironball.shikimori.domain.entities.common

import ru.ironball.shikimori.domain.entities.person.Person
import ru.ironball.shikimori.domain.entities.person.PersonWithRoles

class Roles(
    val mainCharacters: List<Person>,
    val minorCharacters: List<Person>,
    val mainAuthors: List<PersonWithRoles>,
    val allAuthors: List<PersonWithRoles>,
)