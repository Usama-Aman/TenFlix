package com.sam.tenflix.pesentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sam.tenflix.pesentation.home.HomeScreenViewModel
import com.sam.tenflix.pesentation.home.HomeScreen
import com.sam.tenflix.pesentation.movie_detail.MovieDetailScreen
import com.sam.tenflix.pesentation.movie_detail.MovieDetailViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppScreens.HomeScreen.route
) {


    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = AppScreens.HomeScreen.route) {
            val viewModel: HomeScreenViewModel = hiltViewModel()
            val nowPlayingState by viewModel.nowPlayingState.collectAsStateWithLifecycle()
            val popularMoviesState by viewModel.popularMoviesState.collectAsStateWithLifecycle()
            val topRatedMoviesState by viewModel.popularMoviesState.collectAsStateWithLifecycle()

            HomeScreen(
                nowPlayingState = nowPlayingState,
                popularMoviesState = popularMoviesState,
                topRatedMoviesState = topRatedMoviesState,
            ) { movieId ->
                navController.navigate(AppScreens.MovieDetail.passMovieId(movieId))
            }
        }

        composable(
            route = AppScreens.MovieDetail.route,
            arguments = listOf(
                navArgument(name = MOVIE_ID) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { navBackStackEntry ->

            val viewModel = hiltViewModel<MovieDetailViewModel>()
            val state by viewModel.movieDetailState.collectAsStateWithLifecycle()

            MovieDetailScreen(state = state){
                navController.popBackStack()
            }
        }

    }

}