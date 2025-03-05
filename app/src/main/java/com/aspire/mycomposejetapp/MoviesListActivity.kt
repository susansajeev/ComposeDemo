package com.aspire.mycomposejetapp

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aspire.mycomposejetapp.ui.theme.MyComposeJetAppTheme

class MoviesListActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeJetAppTheme {
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MoviesListContent(name: String, modifier: Modifier = Modifier) {
    MyMoviesList(modifier)
}



@Composable
fun MyMoviesList(modifier: Modifier = Modifier,
    movieList: List<String> = listOf(
        "HarryPotter",
        "Happy Feet two",
        "SpiderMan",
        "Black Pantar",
        "HarryPotter1",
        "Happy Feet two2",
        "SpiderMan3",
        "Black Pantar 4",
        "HarryPotter 6",
        "Happy Feet two 7",
        "SpiderMan 8",
        "Black Pantar 9",
        "HarryPotter 11",
        "Happy Feet two 45",
        "SpiderMan 56",
        "Black Pantar 43"
    )
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(movieList) { item ->
                MoviewRow(item){ movie: String ->
                    Log.d("MoviewName on clciking", movie)

                }
            }
        }
    }
}

@Composable
fun MoviewRow(movieName: String, onItemClick: (String)-> Unit ={}) {

    var expanded by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                onItemClick(movieName)
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
                Image(
                    painter = painterResource(R.drawable.moview), "",
                    Modifier.size(40.dp)
                )
                Spacer(Modifier.width(5.dp))
                Text(movieName)
            }
            Image(painter = painterResource(R.drawable.delete), "",
                Modifier.size(30.dp))

        }
        AnimatedVisibility(expanded) {
            Column {
                Text("Jetpack Compose is a modern UI toolkit that is designed to simplify UI development in Android. It consists of a reactive programming model with conciseness and ease of Kotlin programming language. It is fully declarative so that you can describe your UI by calling some series of functions that will transform your data into a UI hierarchy.")
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

@Preview(showBackground = true)
@Composable
fun MoviesListContentPreview() {
    MyComposeJetAppTheme {
        MoviesListContent("Android")
    }
}