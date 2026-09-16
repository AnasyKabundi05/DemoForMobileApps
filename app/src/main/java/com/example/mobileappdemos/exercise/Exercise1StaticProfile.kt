package com.example.mobileappdemos.exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
