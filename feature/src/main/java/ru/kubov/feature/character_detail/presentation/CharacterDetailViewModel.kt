package ru.kubov.feature.character_detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.kubov.feature.domain.model.Character

/**
 * View model in screen showing detail information of character update information for [CharacterDetailFragment]
 */
class CharacterDetailViewModel : ViewModel() {

    private var _character: MutableLiveData<Character> = MutableLiveData()
    /**
     * Property updating information about character
     */
    val character: LiveData<Character> get() = _character

    fun setCharacter(character: Character) {
        _character.value = character
    }
}