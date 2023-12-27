package com.sam.tenflix.pesentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sam.tenflix.pesentation.home.components.HomeTopBar
import com.sam.tenflix.pesentation.home.components.MoviesListItem

@Composable
fun HomeScreen(
    nowPlayingState: HomeScreenViewModel.MoviesState,
    popularMoviesState: HomeScreenViewModel.MoviesState,
    topRatedMoviesState: HomeScreenViewModel.MoviesState,
    onMovieClicked: (Int) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            HomeTopBar()

            MoviesListItem(
                movies = popularMoviesState.movies,
                title = "Popular",
                isLoading = popularMoviesState.isLoading,
                onMovieClicked = onMovieClicked
            )

            MoviesListItem(
                movies = nowPlayingState.movies,
                title = "Now Playing",
                isLoading = nowPlayingState.isLoading,
                onMovieClicked = onMovieClicked
            )

            MoviesListItem(
                movies = topRatedMoviesState.movies,
                isLoading = topRatedMoviesState.isLoading,
                title = "Top Rated",
                onMovieClicked = onMovieClicked
            )

        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        nowPlayingState = HomeScreenViewModel.MoviesState(),
        popularMoviesState = HomeScreenViewModel.MoviesState(),
        topRatedMoviesState = HomeScreenViewModel.MoviesState(),
    ) {

    }
}

