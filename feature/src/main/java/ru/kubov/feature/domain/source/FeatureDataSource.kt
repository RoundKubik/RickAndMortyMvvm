package ru.kubov.feature.domain.source

import ru.kubov.common.domain.model.RickAndMortyResult
import ru.kubov.feature.data.remote.model.CharacterResponse

/**
 * Interface for data source used in feature module
 */
interface FeatureDataSource {
    /**
     * Method for provide list of characters
     * @return [RickAndMortyResult<List<CharacterResponse>?>]
     */
    fun getCharacters(): RickAndMortyResult<List<CharacterResponse>?>
}