package com.modularizedapptemplate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.common.ui.theme.ModularizedAppTemplateTheme

import com.modularizedapptemplate.navigation.PokedexNavigationRoute
import com.example.feature.home.Home
import com.example.feature.profile.Profile

@Composable
fun PokedexMainApp() {
    ModularizedAppTemplateTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = PokedexNavigationRoute.Home.route
            ) {
                // Add a Composable to the NavGraphBuilder
                composable(route = PokedexNavigationRoute.Home.route) { navBackStackEntry ->
                    Home(
                        onPokemonClicked = { pokemonId ->
                            navController.navigate(PokedexNavigationRoute.Profile.createRoute(pokemonId))
                        }
                    )
                }

                composable(
                    route = PokedexNavigationRoute.Profile.route,
                    arguments = PokedexNavigationRoute.Profile.arguments
                ) { navBackStackEntry ->
                    Profile(
                        onBackClicked = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}