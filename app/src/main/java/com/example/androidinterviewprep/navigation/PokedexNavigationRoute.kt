package com.modularizedapptemplate.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core.common.ui.navigation.POKEMON_ID_ARG

/* The ability to use serializable objects (specifically with Kotlin Serialization) for navigation routes
* was introduced in 2.8.0. String routes are generally considered outdated now.
* TODO - update this to use Nav 3
*/

sealed interface PokedexNavigationRoute {
    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    data object Home : PokedexNavigationRoute {
        override val route = "home"
    }
    data object Profile : PokedexNavigationRoute {
        override val route = "profile/{$POKEMON_ID_ARG}"
        override val arguments: List<NamedNavArgument>
            = listOf(navArgument(POKEMON_ID_ARG) {type = NavType.IntType})

        fun createRoute(pokemonId: Int) = "profile/$pokemonId"
    }
}
