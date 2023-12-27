package com.sam.tenflix.pesentation.now_playing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.tenflix.pesentation.now_playing.components.HomeTopBar
import com.sam.tenflix.pesentation.now_playing.components.MoviesListItem

@Composable
fun HomeScreen(
    nowPlayingState: HomeScreenViewModel.NowPlayingState
) {

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {

        Column(
            Modifier
                .fillMaxSize()
        ) {

            HomeTopBar(
                modifier = Modifier
                    .padding(top = 30.dp)
            )

            MoviesListItem(
                movies = nowPlayingState.movies,
                title = "Now Playing"
            )
        }

    }

}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(nowPlayingState = HomeScreenViewModel.NowPlayingState())
}

