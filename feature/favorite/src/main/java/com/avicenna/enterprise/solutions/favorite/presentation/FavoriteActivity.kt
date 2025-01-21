package com.avicenna.enterprise.solutions.favorite.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.avicenna.enterprise.solutions.favorite.presentation.ui.theme.MovieFlixTheme

class FavoriteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieFlixTheme {

            }
        }
    }
}
