package ru.kubov.feature.characters.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.kubov.feature.databinding.ItemCharacterBinding
import ru.kubov.feature.domain.model.Character


/**
 * Holder of views with character information
 *
 * @constructor create holder with binding and click callback
 *
 *  @param itemCharacterBinding
 * @param onClick
 */
class CharacterViewHolder(
    private val itemCharacterBinding: ItemCharacterBinding,
    private val onClick: (Character) -> Unit
) : RecyclerView.ViewHolder(itemCharacterBinding.root) {

    private lateinit var character: Character

    init {
        itemView.setOnClickListener {
            onClick.invoke(character)
        }
    }

    /**
     * Method for bind and provide data to layout
     * @param item - element of [Character]
     */
    fun bind(item: Character) {
        character = item
        with(item) {
            itemCharacterBinding.itemCharacterIvCharacterImage.load(
                image
            )
            itemCharacterBinding.itemCharacterTvCharacterTitle.text = name
            itemCharacterBinding.itemCharacterTvCharacterLocation.text = location
        }
    }
}