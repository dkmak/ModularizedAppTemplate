package com.example.network.model

import com.example.model.Pokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// investigate why this annotation is recommended?
@Serializable
data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)