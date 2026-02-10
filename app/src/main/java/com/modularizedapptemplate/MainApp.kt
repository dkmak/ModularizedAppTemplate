package com.modularizedapptemplate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.core.common.ui.theme.ModularizedAppTemplateTheme
import com.modularizedapptemplate.navigation.AppNavHost

@Composable
fun MainApp() {
    ModularizedAppTemplateTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            AppNavHost(navController)
        }
    }
}