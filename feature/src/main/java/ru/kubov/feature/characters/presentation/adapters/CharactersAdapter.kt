package ru.kubov.feature.characters.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.kubov.feature.databinding.ItemCharacterBinding
import ru.kubov.feature.domain.model.Character

/**
 * Adapter for character [Character]
 *
 * @constructor create adapter with property callback click on some character
 * @param onClickAction
 */
class CharactersAdapter(
    private val onClickAction: (Character) -> Unit
) :
    ListAdapter<Character, CharacterViewHolder>(CharacterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, onClickAction)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }
}
