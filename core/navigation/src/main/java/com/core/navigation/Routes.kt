package com.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable // need to move serialization out of this module with lib
    data object HomeRoute: Route
}
