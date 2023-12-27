package com.sam.tenflix.pesentation.movie_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sam.tenflix.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieDetailScreen(
    state: MovieDetailViewModel.MovieDetailUIState,
    onBackClicked: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 50.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ImageSection(
                imagePath = state.movieDetail.fullPosterPath,
                modifier = Modifier.height(300.dp),
                onBackClicked = onBackClicked
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = state.movieDetail.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp
                    )
                )

                if (!state.movieDetail.adult)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_adult_movie),
                        contentDescription = null,
                        tint = Color.White
                    )
            }

            Text(
                text = state.movieDetail.tagline,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.White
                ),
                modifier = Modifier.padding(
                    horizontal = 20.dp
                )
            )

            FlowRow(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                repeat(state.movieDetail.genres.size) { index ->
                    ChipItem(text = state.movieDetail.genres[index].name)
                }
            }


        }
    }

}

@Composable
fun ImageSection(
    modifier: Modifier = Modifier,
    imagePath: String,
    onBackClicked: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.White)
                .clipToBounds(),
            model = imagePath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(5.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .clickable { onBackClicked() }
            )
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipItem(text: String) {
    Chip(
        modifier = Modifier.padding(end = 4.dp),
        onClick = {},
        leadingIcon = {},
        border = BorderStroke(1.dp, Color(0xFF3B3A3C))
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun MovieDetailScreenPreview() {
    MovieDetailScreen(MovieDetailViewModel.MovieDetailUIState()) {

    }
}