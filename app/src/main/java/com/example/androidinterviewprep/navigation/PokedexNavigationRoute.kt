package com.example.androidinterviewprep.navigation

/*
class PokedexNavigationRoute {
}*/

sealed interface PokedexNavigationRoute {

    // does this need to be serializable?
    data object Home : PokedexNavigationRoute {
        val route = "home"
    }
    data object Profile : PokedexNavigationRoute {
        val route = "profile"
    }
}
