package com.example.androidinterviewprep

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidinterviewprep.navigation.PokedexNavigationRoute
import com.example.core.common.ui.theme.AndroidInterviewPrepTheme
import com.example.feature.home.Home
import com.example.feature.profile.Profile

@Composable
fun PokedexMainApp() {

    AndroidInterviewPrepTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = PokedexNavigationRoute.Home.route
            ) {
                composable(route = PokedexNavigationRoute.Home.route) {
                    Home(
                        onPokemonClicked = {
                            navController.navigate(PokedexNavigationRoute.Profile.route)
                        }
                    )
                }

                composable(route = PokedexNavigationRoute.Profile.route) {
                    Profile()
                }
            }
        }
    }
}