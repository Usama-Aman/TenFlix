package com.sam.tenflix.pesentation.now_playing.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sam.tenflix.domain.model.NowPlayingMovies

@Composable
fun NowPlayingMoviesListItem(
    movies: NowPlayingMovies,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {

    }
}


@Preview
@Composable
fun NowPlayingMoviesListItemPreview() {
    NowPlayingMoviesListItem(NowPlayingMovies())
}