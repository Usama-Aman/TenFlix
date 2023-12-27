package com.sam.tenflix.pesentation.navigation

sealed class AppScreens(val route : String) {
    data object HomeScreen : AppScreens("HomeScreen")
}