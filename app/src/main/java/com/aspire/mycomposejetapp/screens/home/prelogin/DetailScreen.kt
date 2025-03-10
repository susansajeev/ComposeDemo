package com.aspire.mycomposejetapp.screens.home.prelogin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aspire.mycomposejetapp.components.MovieNoteTestFields
import com.aspire.mycomposejetapp.model.Movie
import com.aspire.mycomposejetapp.model.entity.MovieTB
import kotlinx.coroutines.flow.collect

@Composable
fun DetailScreen(navController: NavController?, movie: Movie) {
    val movies = remember { mutableStateListOf<Movie>() }
    SetDetailViewmode(movie)
}

@Composable
fun SetDetailViewmode(movie: Movie, detailViewModel: DetailViewModel = hiltViewModel()){

    val movies = detailViewModel.movieList.collectAsState().value

    Column(Modifier
        .fillMaxSize()
    ) {

        MovieNoteTestFields(movie = movie, onButtonClick = { s: String, s1: String ->
            //addData(s, s1, movies);
            detailViewModel.addData(s,s1)

        })

        HorizontalDivider(
            Modifier
                .height(2.dp)
                .padding(20.dp), color = Color.White
        )
        LazyColumn(Modifier
            .padding(10.dp)) {
            items(movies) { item ->
                MovieDetaRow(item) {
                    //DeleteDta
                    detailViewModel.DeleteDta(it)
                }


            }

        }
    }
}

fun DeleteDta(it: MutableList<Movie>, it1: Movie) {
    it.remove(it1)

}


@Composable
fun MovieDetaRow(movie: MovieTB, onItemClick: (MovieTB) -> Unit = {}) {
    Column(Modifier.clickable {
        onItemClick(movie)
    }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 4.dp, bottomStart = 4.dp, bottomEnd = 15.dp))
                .background(Color(0xFFCAB4FA)) // Purple background
                .padding(16.dp)
        ) {
            Column {
                // Top Stylable Text
                Text(
                    text = movie.name!!,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Bottom Stylable Text
                Text(
                    text = movie.writer!!,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black.copy(alpha = 0.8f)
                )
            }
        }

    }


}

fun addData(s: String, s2: String, mList: MutableList<Movie>?) {
    Log.d("Movie=== $s2", s)
    var movie = Movie(Title = s, Writer = s2)
    if (mList != null) {
        mList.add(movie)
    }


}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(
    movie: Movie = Movie(
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
    )
) {
    DetailScreen(null, movie)

//    MovieNoteTestFields(movie = movie, onButtonClick = { s: String, s1: String ->
//        addData(s, s1, null)
//
//    })

}