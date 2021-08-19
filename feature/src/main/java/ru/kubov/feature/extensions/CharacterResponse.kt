package ru.kubov.feature.extensions

import ru.kubov.feature.data.remote.model.CharacterResponse
import ru.kubov.feature.domain.model.Character

/**
 * Mapper from [CharacterResponse] data layer to [Character] domain model
 * @return [Character]
 */
fun CharacterResponse.mapToCharacter(): Character {
    return Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        originName,
        locationName,
        image,
        created
    )
}