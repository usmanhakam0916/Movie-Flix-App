package com.avicenna.enterprise.solutions.movieflix.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.avicenna.enterprise.solutions.movieflix.R
import com.avicenna.enterprise.solutions.movieflix.ui.theme.Montserrat


@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.size(200.dp).align(Alignment.Center),
        )
        AnimatePreLoader(
            modifier = Modifier
                .size(200.dp).align(Alignment.Center))
        Text(
            text = stringResource(R.string.app_name),
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 36.dp)
        )
    }
}

@Composable
fun AnimatePreLoader(modifier: Modifier = Modifier) {
    val prelaoderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            resId = R.raw.splash_animation
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        prelaoderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )

    LottieAnimation(
        composition = prelaoderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
    )
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}