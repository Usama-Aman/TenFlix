package com.sam.tenflix.pesentation.now_playing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.sam.tenflix.pesentation.now_playing.components.NowPlayingMoviesListItem

@Composable
fun NowPlayingScreen(viewModel: NowPlayingMoviesViewModel) {
    val state by viewModel.nowPlayingState.collectAsState()

    NowPlayingMoviesListItem(state.movies.first())
}


