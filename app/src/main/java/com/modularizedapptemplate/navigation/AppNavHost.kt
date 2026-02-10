package com.modularizedapptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.core.navigation.Route.HomeRoute
import com.feature.home.Home

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> { navBackStackEntry ->
            Home()
        }
    }
}