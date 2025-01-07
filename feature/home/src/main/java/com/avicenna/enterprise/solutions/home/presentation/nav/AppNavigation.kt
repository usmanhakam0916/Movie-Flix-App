package com.avicenna.enterprise.solutions.home.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.avicenna.enterprise.solutions.home.presentation.HomeScreen

const val homeRoute = "home"

fun NavGraphBuilder.homeScreen() {
    composable(route = homeRoute) {
        HomeScreen()
    }
}
