package com.avicenna.enterprise.solutions.movieflix

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.avicenna.enterprise.solutions.home.presentation.nav.homeRoute
import com.avicenna.enterprise.solutions.home.presentation.nav.homeScreen


@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = homeRoute) {
        homeScreen()
        
    }
}