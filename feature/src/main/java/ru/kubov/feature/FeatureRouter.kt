package ru.kubov.feature

import ru.kubov.feature.domain.model.Character

/**
 * The interface for declaration of navigation in Feature Module
 *
 */
interface FeatureRouter {

    /**
     * Declaration of navigation from characters screen to character details screen
     *
     * @param character [Character] parameter fro displaying detail information about single character
     */
    fun openCharacterDetailsScreen(character: Character)
}