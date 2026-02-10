package com.core.navigation

interface Navigator {
    fun navigate(destination: Route)
    fun goBack()
}