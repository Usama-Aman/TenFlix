package com.sam.tenflix.pesentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.tenflix.pesentation.now_playing.NowPlayingMoviesViewModel
import com.sam.tenflix.pesentation.now_playing.NowPlayingScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppScreens.HomeScreen.route
) {


    NavHost(navController = navController, startDestination = startDestination){

        composable(route = AppScreens.HomeScreen.route){
            val viewModel: NowPlayingMoviesViewModel = hiltViewModel()
            val nowPlayingState = viewModel.nowPlayingState.collectAsStateWithLifecycle()
            NowPlayingScreen(nowPlayingState)
        }

    }

}