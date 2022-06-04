package ru.ironball.shikimori.data.entities.common.mappers

import ru.ironball.shikimori.data.entities.common.RolesResponse
import ru.ironball.shikimori.domain.entities.common.Roles
import ru.ironball.shikimori.domain.entities.person.PersonWithRoles

fun List<RolesResponse>.toRoles(): Roles {
    val allAuthors = filter { it.author != null }
        .map { PersonWithRoles(it.author!!.toPerson(), it.rolesRussian) }

    val mainAuthors = allAuthors.filter { "Режиссёр" in it.roles || "Автор оригинала" in it.roles || "Сюжет и иллюстрации" in it.roles || "Сюжет" in it.roles || "Рисовка" in it.roles }

    val minorCharacters = filter { it.character != null && "Main" !in it.roles }
        .map { it.character!!.toPerson() }

    val mainCharacters = filter { it.character != null && "Main" in it.roles }
        .map { it.character!!.toPerson() }

    return Roles(mainCharacters, minorCharacters, mainAuthors, allAuthors)
}