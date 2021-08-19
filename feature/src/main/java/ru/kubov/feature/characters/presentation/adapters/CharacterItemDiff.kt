package ru.kubov.feature.characters.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.kubov.feature.domain.model.Character

class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}