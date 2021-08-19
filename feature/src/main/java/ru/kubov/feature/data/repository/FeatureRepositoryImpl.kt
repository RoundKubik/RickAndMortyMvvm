package ru.kubov.feature.data.repository

import ru.kubov.common.domain.model.RickAndMortyResult
import ru.kubov.feature.domain.model.Character
import ru.kubov.feature.domain.model.CharactersError
import ru.kubov.feature.domain.repository.FeatureRepository
import ru.kubov.feature.domain.source.FeatureDataSource
import ru.kubov.feature.extensions.mapToCharacter
import javax.inject.Inject

/**
 * Implementation of feature module repository
 * @constructor create repository with [FeatureDataSource]
 * @param featureDataSource
 */
class FeatureRepositoryImpl @Inject constructor(private val featureDataSource: FeatureDataSource) : FeatureRepository {

    override fun getCharacters(): RickAndMortyResult<List<Character>?> {
        return when (val charactersResult = featureDataSource.getCharacters()) {
            is RickAndMortyResult.Success -> {
                val result = charactersResult.data?.map {
                    it.mapToCharacter()
                }
                RickAndMortyResult.Success(result)
            }
            is RickAndMortyResult.Error -> {
                RickAndMortyResult.Error(charactersResult.error)
            }
        }
    }
}