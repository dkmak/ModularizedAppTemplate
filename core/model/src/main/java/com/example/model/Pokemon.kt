package com.example.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Pokemon(
    val page: Int = 0,
    @SerialName("name")
    val nameField: String,
    @SerialName("url")
    val url: String
) {

    val name: String
        get() = nameField.replaceFirstChar { it.uppercase() }

    val pokedexIndex: Int
        get() = url.split("/".toRegex()).dropLast(1).lastOrNull()?.toIntOrNull()?: 0

    val spriteUrl: String
        inline get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/${pokedexIndex}.png"

    val animatedUrl: String
        inline get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +
                "versions/generation-v/black-white/animated/${pokedexIndex}.gif"
}