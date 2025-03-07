package com.aspire.mycomposejetapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aspire.mycomposejetapp.model.Movie

@Composable
fun MovieNoteTestFields(
    movie: Movie,
    onButtonClick: (String, String) -> Unit,

    ){
    var text1 by remember() { mutableStateOf("") }
    text1 = movie.Title!!
    var text2 by remember() { mutableStateOf("") }
    text2 = movie.Writer!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text1,
            onValueChange = {
                text1 = it
                movie.Title = text1
                            },
            label = { Text("Enter Movie Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text2,
            onValueChange = { text2 = it
                movie.Writer = text2},
            label = { Text("Enter Writer Names") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onButtonClick(text1, text2)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }

}

