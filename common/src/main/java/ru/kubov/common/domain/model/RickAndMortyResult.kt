package ru.kubov.common.domain.model

import ru.kubov.common.error.ErrorEntity

/**
 * Sealed class for pass data of success [RickAndMortyResult.Success] or error [RickAndMortyResult.Error]
 */
sealed class RickAndMortyResult<T> {
    data class Success<T>(val data: T): RickAndMortyResult<T>()
    data class Error<T>(val error: ErrorEntity): RickAndMortyResult<T>()
}

