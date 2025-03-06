package com.aspire.mycomposejetapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aspire.mycomposejetapp.MainActivity
import com.aspire.mycomposejetapp.model.Movie
import com.aspire.mycomposejetapp.screens.home.LoginScreen
import com.aspire.mycomposejetapp.screens.home.prelogin.DetailScreen
import com.aspire.mycomposejetapp.screens.home.prelogin.JetTipScreen
import com.aspire.mycomposejetapp.screens.home.prelogin.MovieScreen
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.LoginScreen.name
    ) {
        //Navgrph builder
        composable(MovieScreens.LoginScreen.name) {
            LoginScreen(navController = navController)

        }
        composable(MovieScreens.JetTipScreen.name) {
            JetTipScreen(navController = navController)
        }
        composable(MovieScreens.MoviewScreen.name) {
            MovieScreen(navController = navController)
        }

        composable( MovieScreens.DetailScreen.name+ "/{movieJSON}",
            arguments = listOf(navArgument("movieJSON") { type = NavType.StringType })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("movieJSON")
            val movieData = URLDecoder.decode(json, StandardCharsets.UTF_8.toString())
            val movie = Gson().fromJson(movieData, Movie::class.java)
            DetailScreen(navController = navController, movie)

        }



    }


}