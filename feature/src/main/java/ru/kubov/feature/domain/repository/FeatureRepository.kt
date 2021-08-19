package ru.kubov.feature.domain.repository

import ru.kubov.common.domain.model.RickAndMortyResult
import ru.kubov.feature.domain.model.Character

/**
 * Interface of main repository of feature module
 */
interface FeatureRepository {

    /**
     * Method for provide list of characters or error from backend or data source part
     * @return [RickAndMortyResult<List<Character>?>]
     */
    fun getCharacters() : RickAndMortyResult<List<Character>?>
}