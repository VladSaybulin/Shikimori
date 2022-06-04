package ru.ironball.shikimori.data.entities.manga.mappers

import ru.ironball.shikimori.data.entities.manga.PublisherResponse
import ru.ironball.shikimori.domain.entities.manga.Publisher

fun PublisherResponse.toPublisher(): Publisher {
    return Publisher(id, name)
}