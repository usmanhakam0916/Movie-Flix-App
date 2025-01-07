package com.avicenna.enterprise.solutions.favorite.presentation.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.avicenna.enterprise.solutions.favorite.presentation.FavoriteScreen

const val favoriteRoute = "favorite"

fun NavGraphBuilder.favoriteScreen(onNavigateBack: () -> Unit) {
    composable(route = favoriteRoute) {
        FavoriteScreen(onNavigateBack = onNavigateBack)
    }
}


fun NavController.navigateToFavorite() {
    this.navigate(route = favoriteRoute)
}