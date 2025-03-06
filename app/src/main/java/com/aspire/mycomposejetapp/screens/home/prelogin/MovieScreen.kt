package com.aspire.mycomposejetapp.screens.home.prelogin

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.aspire.mycomposejetapp.R
import com.aspire.mycomposejetapp.model.Movie
import com.aspire.mycomposejetapp.model.getMoview
import com.aspire.mycomposejetapp.navigation.MovieScreens
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("My List") },
            actions = {
                IconButton(onClick = { /* Handle action */ }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background), // Replace with your icon
                        contentDescription = "Refresh"
                    )
                }
            }
        )
    }
    ) { innerPadding ->
        MoviesListContent(
            name = "Android",
            modifier = Modifier.padding(innerPadding),
            navController
        )
    }

}

@Composable
fun MoviesListContent(name: String, modifier: Modifier = Modifier,navController: NavController) {
    MyMoviesList(modifier, navController)
}



@Composable
fun MyMoviesList(modifier: Modifier = Modifier, navController: NavController
) {
    var movieList = getMoview()
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(movieList) { item ->
                MoviewRow(item){ movie: Movie ->
                    val jsonMovie = Gson().toJson(movie)
                    Log.d("MoviewName on clciking", jsonMovie)
                    //as the movie contains special charaters and issue on sending, we are enoding the datas
                    var data = URLEncoder.encode(jsonMovie, StandardCharsets.UTF_8.toString())
                    navController.navigate(route = MovieScreens.DetailScreen.name+ "/$data")
                    Log.d("MoviewName on clciking", movie.Title!!)

                }
            }
        }
    }
}

@Composable
fun MoviewRow(movie: Movie, onItemClick: (Movie)-> Unit ={}) {

    var expanded by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onItemClick(movie)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .clip(RoundedCornerShape(10.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
//                Image(
//                    painter = painterResource(R.drawable.moview), "",
//                    Modifier.size(40.dp)
//                )
                //imge from url -coil
                AsyncImage(
                    movie.Images[0],"",Modifier.size(90.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Black, CircleShape), contentScale = ContentScale.FillHeight

                )
                Spacer(Modifier.width(5.dp))
                movie.Title?.let { Text(it) }
            }
            Image(painter = painterResource(R.drawable.delete), "",
                Modifier.size(30.dp))

        }
        AnimatedVisibility(expanded) {
            Column {
                movie.Plot?.let { Text(it) }
            }
        }

        Icon(imageVector = if(expanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown ,"",
            modifier = Modifier.size(25.dp)
                .clickable {
                    expanded = !expanded

                }
                .align(Alignment.CenterHorizontally)
        )
    }
}