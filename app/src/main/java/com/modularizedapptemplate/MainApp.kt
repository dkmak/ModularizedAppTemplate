package com.modularizedapptemplate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.core.common.ui.theme.ModularizedAppTemplateTheme
import com.feature.home.Home
import kotlinx.serialization.Serializable

@Serializable // need to move serialization out of this module with lib
object Home

@Composable
fun MainApp() {
    ModularizedAppTemplateTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Home
            ) {
                // Add a Composable to the NavGraphBuilder
                composable<Home> { navBackStackEntry ->
                    Home()
                }
            }
        }
    }
}