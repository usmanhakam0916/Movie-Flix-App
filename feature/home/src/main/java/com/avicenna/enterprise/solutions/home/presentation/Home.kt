package com.avicenna.enterprise.solutions.home.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
            AppBar(
                onSearchClick = {},
                onFavoriteClick = {},
                onWishlistClick = {}
            )
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

                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 16.dp)
                        ) {
                            Text(
                                text = "Musafa: The king",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Adventure-family-Animation",
                                style = MaterialTheme.typography.titleSmall,
                                color = Color.White
                            )
                        }
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
                Text(
                    text = "Upcoming Movies",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 24.dp, start = 8.dp)
                )

            }
        }
    }
}

@Composable
fun AppBar(
    onSearchClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    onWishlistClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = Color.Black)
            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            modifier = Modifier.weight(3f)
        )
        IconButton(onClick = onSearchClick) {
            Icon(
                painter = painterResource(R.drawable.ic_nav_search),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
        }
        IconButton(onClick = onWishlistClick) {
            Icon(
                painter = painterResource(R.drawable.ic_watchlist),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
        }
        IconButton(onClick = onFavoriteClick) {
            Icon(
                painter = painterResource(R.drawable.fav_outline),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Composable
fun MovieCard(
    @StringRes rating: Int,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(50.dp).height(100.dp),
        border = BorderStroke(1.dp,Color.White)
    ) {
        Text(
            text = stringResource(rating),
            fontSize = 12,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Image(
            painter = painterResource(image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}




@Preview(showBackground = true, name = "HomePreview", showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}