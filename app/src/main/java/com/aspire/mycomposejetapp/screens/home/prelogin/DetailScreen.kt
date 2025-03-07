package com.aspire.mycomposejetapp.screens.home.prelogin

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.aspire.mycomposejetapp.components.MovieNoteTestFields
import com.aspire.mycomposejetapp.model.Movie

@Composable
fun DetailScreen(navController: NavController, movie: Movie) {
    MovieNoteTestFields(movie = movie, onButtonClick = { s: String, s1: String ->
        addData(s,s1);

    })
}

fun addData(s: String, s2: String) {
    Log.d("Movie=== $s2", s)
}


@Preview
@Composable
fun DetailScreenPreview( movie: Movie = Movie(
    "The Avengers",
    "2012",
    "Joss Whedon",
    "Joss Whedon (screenplay), Zak Penn (story), Joss Whedon (story)",
    "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
    "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
    "English, Russian",
    "USA",
    "Nominated for 1 Oscar. Another 34 wins & 75 nominations.",
    listOf(
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTA0NjY0NzE4OTReQTJeQWpwZ15BbWU3MDczODg2Nzc@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMjE1MzEzMjcyM15BMl5BanBnXkFtZTcwNDM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMwMzM2MTg1M15BMl5BanBnXkFtZTcwNjM4ODY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4NzM2Mjc5MV5BMl5BanBnXkFtZTcwMTkwOTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3MzQ3NjA5N15BMl5BanBnXkFtZTcwMzY5OTY3Nw@@._V1_SX1777_CR0,0,1777,999_AL_.jpg"
    )
) ) {
    MovieNoteTestFields(movie = movie, onButtonClick = { s: String, s1: String ->
        addData(s,s1)

    })

}