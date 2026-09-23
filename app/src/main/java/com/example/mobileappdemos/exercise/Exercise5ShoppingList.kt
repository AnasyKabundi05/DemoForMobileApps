package com.example.mobileappdemos.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Exercise5ShoppingList(){
    var newItem by rememberSaveable { mutableStateOf("") }
    val shoppingItems = remember { mutableStateListOf("Rice", "Tea") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Shopping list", fontSize = 28.sp)
        OutlinedTextField(
            value = newItem,
            onValueChange = { newItem = it },
            label = { Text("New item") },
            modifier = Modifier.fillMaxWidth()
        )

        Button( onClick = { shoppingItems.add(newItem.trim())
                newItem = ""
        },
            enabled = newItem.isNotBlank()
        ){
            Text("Add item")
        }
        Text("${shoppingItems.size} item(s)")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(shoppingItems ) { item ->
                 ShoppingListItem(
                    item = item,
                    onRemove = { shoppingItems.remove(item) }
                )
            }
        }
    }
}

@Composable
private fun ShoppingListItem(item : String, onRemove: () -> Unit) {

    Card(modifier = Modifier.fillMaxWidth()){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(item)
            TextButton(onClick = onRemove) {
                Text("Remove")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Exercise5Preview(){
    Exercise5ShoppingList()
}