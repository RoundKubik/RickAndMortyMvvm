package ru.kubov.feature.data.remote.model


/**
 * Model of character in data layer
 */
data class CharacterResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originName: String,
    val locationName: String,
    val image: String,
    val created: String
)