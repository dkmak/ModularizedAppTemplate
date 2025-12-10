package com.example.network.model

import com.example.model.Pokemon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// investigate why this annotation is recommended?
@Serializable
data class PokemonResponse(
    @SerialName val count: Int,
    @SerialName val next: String?,
    @SerialName val previous: String?,
    @SerialName val results: List<Pokemon>
)