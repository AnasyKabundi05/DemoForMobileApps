package com.example.mobileappdemos.demos

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private enum class Demo(val title: String) {
    StaticUi("1. Static Compose UI"),
    Recomposition("2. Recomposition"),
    TextInput("3. Text input and validation"),
    Profile("4. Interactive profile"),
    ShoppingList("5. Shopping list")
}

@Composable
fun MobileAppDemos() {
    var selectedDemo: Demo? by rememberSaveable { mutableStateOf<Demo?>(null) }

    if (selectedDemo == null) {
        DemoMenu(onSelect = { selectedDemo = it })
    } else {
        DemoScreen(
            demo = selectedDemo!!,
            onBack = { selectedDemo = null }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DemoMenu(onSelect: (Demo) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mobile App Demos") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Choose a classroom demonstration")
            Demo.entries.forEach { demo ->
                Button(
                    onClick = { onSelect(demo) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(demo.title)
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun DemoScreen(demo: Demo, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(demo.title) },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp)
        ) {
            when (demo) {
                Demo.StaticUi -> StaticProfile()
                Demo.Recomposition -> Exercise2Counter()
                Demo.TextInput -> Exercise3NameInput()
                Demo.Profile -> Exercise4InteractiveProfile()
                Demo.ShoppingList -> Exercise5ShoppingList()
            }
        }
    }
}

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

@Composable
fun Exercise3NameInput() {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student name") },
            modifier = Modifier.fillMaxWidth()
        )

        if (name.isBlank()) {
            Text("Enter your name")
        } else {
            Text("Welcome, $name")
        }

        Text("Characters entered: ${name.length}")
    }
}

@Preview(showBackground = true)
@Composable
private fun Exercise3Preview() {
    Exercise3NameInput()
}

@Composable
fun Exercise4InteractiveProfile() {
    var name by rememberSaveable { mutableStateOf("") }
    var score by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Student profile", fontSize = 28.sp)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Student name") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(if (name.isBlank()) "Enter your name" else "Welcome, $name")
        Text("Score: $score", fontSize = 22.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { score++ }) {
                Text("Increase")
            }
            OutlinedButton(onClick = { score = 0 }) {
                Text("Reset")
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
