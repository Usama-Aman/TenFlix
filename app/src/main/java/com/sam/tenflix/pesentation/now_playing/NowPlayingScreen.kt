package com.sam.tenflix.pesentation.now_playing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.sam.tenflix.domain.model.NowPlayingMovies
import com.sam.tenflix.pesentation.now_playing.components.NowPlayingMoviesListItem

@Composable
fun NowPlayingScreen(nowPlayingState: State<NowPlayingMoviesViewModel.NowPlayingState>) {
    NowPlayingMoviesListItem(NowPlayingMovies())
}


