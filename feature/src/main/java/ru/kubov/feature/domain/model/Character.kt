package ru.kubov.feature.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Model of character in domain layer
 */
@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
    val created: String,
) : Parcelable