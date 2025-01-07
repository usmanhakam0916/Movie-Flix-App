package com.avicenna.enterprise.solutions.favorite.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.avicenna.enterprise.solutions.favorite.presentation.ui.screen.FavoriteScreen


fun NavGraphBuilder.favoriteScreen(onNavigateBack: () -> Unit) {
    composable(route = "favorite") {
        FavoriteScreen(onNavigateBack = onNavigateBack)
    }
}


fun NavController.navigateToFavorite() {
    this.navigate(route = "favorite")
}