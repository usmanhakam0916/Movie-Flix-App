package com.avicenna.enterprise.solutions.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avicenna.enterprise.solutions.home.R
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .fillMaxSize()
        ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    modifier = Modifier.weight(3f)
                )
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.ic_nav_search),
                        contentDescription = null,
                        tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_watchlist),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.fav_outline),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF00008B))
                    .verticalScroll(rememberScrollState())
            ) {
                val pagerState = rememberPagerState(initialPage = 0)
                val imageSlider = listOf(
                    painterResource(R.drawable.sale),
                    painterResource(R.drawable.sale),
                    painterResource(R.drawable.sale),
                )
                LaunchedEffect(Unit) {
                    while (true) {
                        yield()
                        delay(3000)
                        pagerState.animateScrollToPage(
                            page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                        )
                    }
                }
                HorizontalPager(
                    count = imageSlider.size,
                    state = pagerState,
                    modifier = Modifier
                        .height(220.dp)
                        .fillMaxWidth()
                ) { page ->
                    Box(
                        Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = imageSlider[page],
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Top overlay
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .drawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Black.copy(alpha = 0.8f), Color.Transparent)
                                        )
                                    )
                                }
                        )

                        // Bottom overlay
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .align(Alignment.BottomCenter)
                                .drawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f))
                                        )
                                    )
                                }
                        )
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true, name = "HomePreview", showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}