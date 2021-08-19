package ru.kubov.feature.domain.model

import ru.kubov.common.error.ErrorEntity

/**
 * Class with specified errors, for update ui, use it if you want show special information about errors in ui
 *
 * [CharactersError.LoadingError] - error of load characters from backend
 */
sealed class CharactersError : ErrorEntity {
    object LoadingError : CharactersError()
}