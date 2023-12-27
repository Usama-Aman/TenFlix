package com.sam.tenflix.pesentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sam.tenflix.domain.model.MoviesModel
import com.sam.tenflix.ui.theme.AppRed

@Composable
fun MoviesListItem(
    modifier: Modifier = Modifier,
    movies: List<MoviesModel>,
    title: String,
    isLoading: Boolean,
    onMovieClicked: (movieId: Int) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White
                ),
                modifier = Modifier.padding(20.dp)
            )

            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    CircularProgressIndicator(
                        color = AppRed
                    )
                }

            } else
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(movies.size) { index ->
                        MovieItem(movie = movies[index]) {
                            onMovieClicked(it)
                        }
                    }
                }

        }
    }
}

@Composable
fun MovieItem(movie: MoviesModel, onMovieClicked: (id: Int) -> Unit) {
    AsyncImage(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onMovieClicked(movie.id ?: -1)
            },
        model = movie.fullPosterPath,
        contentScale = ContentScale.Crop,
        contentDescription = null,
    )
}


@Preview
@Composable
fun MoviesListItemPreview() {
    MoviesListItem(
        movies = listOf(), title = "NowPlaying",
        isLoading = false,
        onMovieClicked = { }
    )
}