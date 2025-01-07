package com.avicenna.enterprise.solutions.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.avicenna.enterprise.solutions.home.presentation.ui.screen.HomeScreen


fun NavGraphBuilder.homeScreen(onNavigateBack: () -> Unit) {
    composable(route = "home") {
        HomeScreen(onNavigateBack = onNavigateBack)
    }
}


fun NavController.navigateToHome() {
    this.navigate("home")
}