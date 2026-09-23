package com.example.mobileappdemos.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Exercise4InteractiveProfile(){

    var name by rememberSaveable { mutableStateOf("") }
    var score by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Text("Student profile", fontSize = 28.sp)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student name") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(if (name.isBlank()) "Enter your name " else "Welcome, $name")
        Text("Score: $score", fontSize = 22.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

            Button(onClick = { score = 0 }) {
                Text("Reset")
            }
        }
    }
}