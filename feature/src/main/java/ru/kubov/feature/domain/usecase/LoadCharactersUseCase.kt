package ru.kubov.feature.domain.usecase

import ru.kubov.common.domain.model.RickAndMortyResult
import javax.inject.Inject
import ru.kubov.feature.domain.model.Character
import ru.kubov.feature.domain.repository.FeatureRepository

class LoadCharactersUseCase @Inject constructor(private val featureRepository: FeatureRepository) {
    operator fun invoke(): RickAndMortyResult<List<Character>?> {
        return featureRepository.getCharacters()
    }
}