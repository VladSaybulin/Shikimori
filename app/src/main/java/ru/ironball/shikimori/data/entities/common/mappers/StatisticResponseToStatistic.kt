package ru.ironball.shikimori.data.entities.common.mappers

import ru.ironball.shikimori.data.entities.common.StatisticResponse
import ru.ironball.shikimori.domain.entities.common.Statistic

fun StatisticResponse.toStatistic(): Statistic {
    return Statistic(
        name = name,
        value = value,
    )
}