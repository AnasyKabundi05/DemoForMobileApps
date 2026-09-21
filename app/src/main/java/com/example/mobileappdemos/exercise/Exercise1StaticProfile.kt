package com.example.mobileappdemos.exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StaticProfile(){

    Column {
        Text("\nName")
        Text("\nScore")

        var modifier = Modifier
            .fillMaxSize()
            .padding(24.dp, 12.dp)

        Button(onClick = {} ){
            Text("Increase")
        }
    }

}

@Composable
fun Exercise2Counter(){

    var score by remember { mutableStateOf(0) }


    Column{
        var modifier = Modifier
            .fillMaxSize()


        Text("Score: $score")

        Button(onClick = {score++} ) {
            Text("Increase")
        }

        Button(onClick = {score--} ) {
            Text("Decrease")
        }

        Button(onClick = {score = 0} ) {
            Text("Reset")
        }
    }
}
