package com.sam.tenflix.pesentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sam.tenflix.pesentation.now_playing.HomeScreenViewModel
import com.sam.tenflix.pesentation.now_playing.HomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppScreens.HomeScreen.route
) {


    NavHost(navController = navController, startDestination = startDestination){

        composable(route = AppScreens.HomeScreen.route){
            val viewModel: HomeScreenViewModel = hiltViewModel()
            val nowPlayingState by viewModel.nowPlayingState.collectAsStateWithLifecycle()
            HomeScreen(nowPlayingState)
        }

    }

}