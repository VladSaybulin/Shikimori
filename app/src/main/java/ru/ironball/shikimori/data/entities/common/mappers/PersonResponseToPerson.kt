package ru.ironball.shikimori.data.entities.common.mappers

import ru.ironball.shikimori.data.entities.common.PersonResponse
import ru.ironball.shikimori.domain.entities.person.Person

fun PersonResponse.toPerson(): Person {
    return Person(
        id = id,
        name = name,
        russianName = russianName.ifEmpty { null },
        image = image,
        url = url
    )
}