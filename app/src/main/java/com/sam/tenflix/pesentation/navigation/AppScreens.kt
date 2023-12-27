package com.sam.tenflix.pesentation.navigation

sealed class AppScreens(val route: String) {
    data object HomeScreen : AppScreens("homeScreen")
    data object MovieDetail : AppScreens("movieDetail/{${MOVIE_ID}}") {
        fun passMovieId(movieId: Int): String {
            return this.route.replace(oldValue = "{${MOVIE_ID}}", newValue = "$movieId")
        }
    }
}

const val MOVIE_ID = "movieId"