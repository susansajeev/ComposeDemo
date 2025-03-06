package com.aspire.mycomposejetapp.screens.home.prelogin

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.aspire.mycomposejetapp.model.Movie
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun DetailScreen(navController: NavController, movie: Movie){

    Text("the detail string ${movie.Title}")
}