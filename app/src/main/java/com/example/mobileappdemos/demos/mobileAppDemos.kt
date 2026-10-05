package com.example.mobileappdemos.demos

import android.R.attr.name
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
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

//@Composable
//fun MobileAppDemos() {
//    var selectedDemo: Demo? by rememberSaveable { mutableStateOf<Demo?>(null) }
//
//    if (selectedDemo == null) {
//        DemoMenu(onSelect = { selectedDemo = it })
//    } else {
//        DemoScreen(
//            demo = selectedDemo!!,
//            onBack = { selectedDemo = null }
//        )
//    }
//}
@Composable
fun MobileAppDemos() {
    var selectedDemo by rememberSaveable {
        mutableStateOf<Demo?>(null)
    }

    val currentDemo = selectedDemo

    if (currentDemo == null) {
        DemoMenu(
            onSelect = { demo ->
                selectedDemo = demo
            }
        )
    } else {
        BackHandler {
            selectedDemo = null
        }

        DemoScreen(
            demo = currentDemo,
            onBack = {
                selectedDemo = null
            }
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
                Demo.StaticUi -> StaticUiDemo()
                Demo.Recomposition -> RecompositionDemo()
                Demo.TextInput -> TextInputDemo()
                Demo.Profile -> ProfileDemo()
                Demo.ShoppingList -> ShoppingListDemo()
            }
        }
    }
}
@Composable
private fun StaticUiDemo() {
    var usePrimary by remember {
        mutableStateOf(true)
    }

    var roundedCorners by remember {
        mutableStateOf(true)
    }

    var message by remember {
        mutableStateOf("Try the button styles below.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "Student profile",
            style = MaterialTheme.typography.headlineMedium,
            color = if (usePrimary) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.secondary
            }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(
                if (roundedCorners) 24.dp else 4.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor =
                    MaterialTheme.colorScheme.onPrimary,
                contentColor =
                    MaterialTheme.colorScheme.primary
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Profile details",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "Name: Mary",
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Score: 12",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Button(
            onClick = {
                message = "Continue clicked."
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue")
        }

        OutlinedButton(
            onClick = {
                message = "Edit profile clicked."
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Edit profile")
        }

        TextButton(
            onClick = {
                message = "Help clicked."
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Help")
        }

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = {
                usePrimary = !usePrimary
            },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("Change heading colour")
        }

        OutlinedButton(
            onClick = {
                roundedCorners = !roundedCorners

            },
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("Change card corners")
        }
    }
}
/*@Composable
private fun StaticUiDemo() {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text("Student profile", fontSize = 28.sp)
        Text("Name: Mary")
        Text("Score: 12")
        Button(onClick = { }) {
            Text("Continue")
        }
    }
}*/

@Composable
private fun RecompositionDemo() {
    var composeScore by remember { mutableIntStateOf(0) }
    var demoKey by remember { mutableIntStateOf(0) }

    // A key recreates this content when the demonstration is reset.
    androidx.compose.runtime.key(demoKey) {
        var ordinaryScore = 0

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Ordinary variable shown: $ordinaryScore")
            OutlinedButton(onClick = { ordinaryScore++ }) {
                Text("Increment ordinary variable")
            }
            Text("The handler runs, but no observable state requests a UI update.")

            HorizontalDivider()

            Text("Compose state shown: $composeScore")
            Button(onClick = { composeScore++ }) {
                Text("Increment Compose state")
            }
            Text("Changing observed state schedules recomposition.")

            Spacer(Modifier.height(8.dp))
            TextButton(
                onClick = {
                    composeScore = 0
                    demoKey++
                }
            ) {
                Text("Reset demonstration")
            }
        }
    }
}

@Composable
private fun TextInputDemo() {
    var name by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
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

@Composable
private fun ProfileDemo() {
    var name by rememberSaveable { mutableStateOf("") }
    var score by rememberSaveable { mutableIntStateOf(0) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
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
            Button(onClick = { score++ }) { Text("Increase score") }
            OutlinedButton(onClick = { score = 0 }) { Text("Reset score") }
        }
    }
}

@Composable
private fun ShoppingListDemo() {
    var newItem by remember { mutableStateOf("") }
    val items = remember { mutableStateListOf("Rice", "Tea") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Shopping list", fontSize = 28.sp)
        OutlinedTextField(
            value = newItem,
            onValueChange = { newItem = it },
            label = { Text("New item") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (newItem.isNotBlank()) {
                    items.add(newItem.trim())
                    newItem = ""
                }
            },
            enabled = newItem.isNotBlank()
        ) {
            Text("Add item")
        }
        Text("${items.size} item(s)")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(items) { item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item)
                        TextButton(onClick = { items.remove(item) }) {
                            Text("Remove")
                        }
                    }
                }
            }
        }
    }
}