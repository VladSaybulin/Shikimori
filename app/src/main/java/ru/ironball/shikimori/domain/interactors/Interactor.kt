package ru.ironball.shikimori.domain.interactors

interface Interactor<T, Params> {
    suspend fun execute(params: Params): T
}