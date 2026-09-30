# 📱 Mobile App Demos

A simple Android application built with **Kotlin** and **Jetpack Compose** to demonstrate fundamental concepts of modern Android UI development.

The app contains a collection of small, interactive demonstrations covering static UI, state, recomposition, text input, interactive profiles, and dynamic lists.

## ✨ Features

The application includes five demonstrations:

1. **Static Compose UI**

   * Basic `Column` layout
   * Text components
   * Button components
   * Introduction to Compose UI structure

2. **Recomposition**

   * Managing UI state with `remember`
   * Incrementing and decrementing a score
   * Resetting state
   * Demonstrates how Compose recomposes when state changes

3. **Text Input and Validation**

   * User text input using `OutlinedTextField`
   * Dynamic text updates
   * Basic validation using `isBlank()`
   * Character count

4. **Interactive Profile**

   * Student name input
   * Score management
   * `rememberSaveable` for state persistence
   * Interactive buttons

5. **Shopping List**

   * Adding items to a list
   * Removing items
   * Dynamic list rendering with `LazyColumn`
   * State management using `mutableStateListOf`
   * Input validation

---

## 🛠️ Technologies Used

* **Kotlin**
* **Android**
* **Jetpack Compose**
* **Material 3**
* **AndroidX**
* **LazyColumn**
* **Compose State**
* **`remember`**
* **`rememberSaveable`**

---

## 📂 Project Structure

```text
app/
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── mobileappdemos/
                        ├── MainActivity.kt
                        │
                        ├── demos/
                        │   └── MobileAppDemos.kt
                        │
                        └── ui/
                            └── theme/
                                ├── Color.kt
                                ├── Theme.kt
                                └── Type.kt
```

### `MainActivity.kt`

The application's entry point.

It enables edge-to-edge display, applies the Compose theme, and displays the `MobileAppDemos` composable.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MobileappdemosTheme {
                Surface {
                    MobileAppDemos()
                }
            }
        }
    }
}
```

### `MobileAppDemos.kt`

Contains the demonstration menu and all five Compose exercises.

The main navigation is handled using the `Demo` enum:

```kotlin
private enum class Demo(val title: String) {
    StaticUi("1. Static Compose UI"),
    Recomposition("2. Recomposition"),
    TextInput("3. Text input and validation"),
    Profile("4. Interactive profile"),
    ShoppingList("5. Shopping list")
}
```

---

## 🧩 Compose Concepts Demonstrated

### 1. Composable Functions

The application is built using composable functions such as:

```kotlin
@Composable
fun Exercise2Counter() {
    // UI
}
```

Composable functions allow the UI to be described declaratively.

---

### 2. State with `remember`

The counter example uses Compose state:

```kotlin
var score by remember { mutableStateOf(0) }
```

When `score` changes, Compose automatically recomposes the parts of the UI that depend on it.

For example:

```kotlin
Button(onClick = { score++ }) {
    Text("Increase")
}
```

---

### 3. State Preservation with `rememberSaveable`

The interactive profile uses:

```kotlin
var name by rememberSaveable { mutableStateOf("") }
var score by rememberSaveable { mutableIntStateOf(0) }
```

`rememberSaveable` allows state to survive configuration changes and other recreation scenarios when the state can be saved.

---

### 4. User Input

The application uses `OutlinedTextField` for user input:

```kotlin
OutlinedTextField(
    value = name,
    onValueChange = { name = it },
    label = { Text("Student name") }
)
```

The UI updates as the user types.

---

### 5. Conditional UI

The name input example demonstrates conditional rendering:

```kotlin
if (name.isBlank()) {
    Text("Enter your name")
} else {
    Text("Welcome, $name")
}
```

Compose automatically updates the displayed content when `name` changes.

---

### 6. Dynamic Lists

The shopping list uses `mutableStateListOf`:

```kotlin
val shoppingItems =
    remember { mutableStateListOf("Rice", "Tea") }
```

The list is displayed using `LazyColumn`:

```kotlin
LazyColumn {
    items(shoppingItems) { item ->
        ShoppingListItem(
            item = item,
            onRemove = {
                shoppingItems.remove(item)
            }
        )
    }
}
```

This demonstrates how Compose can efficiently display and update collections of data.

---

## 🚀 Getting Started

### Prerequisites

Before running the project, make sure you have:

* Android Studio installed
* Android SDK configured
* A compatible Android emulator or physical Android device
* Kotlin and Android development support enabled

### Installation

1. Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/mobile-app-demos.git
```

2. Open the project in **Android Studio**.

3. Allow Gradle to sync and download the required dependencies.

4. Select an emulator or connected Android device.

5. Click **Run ▶** in Android Studio.

---

## ▶️ Using the Application

When the application starts, the **Mobile App Demos** menu is displayed.

Select one of the available demonstrations:

```text
Mobile App Demos

Choose a classroom demonstration

[ 1. Static Compose UI ]
[ 2. Recomposition ]
[ 3. Text input and validation ]
[ 4. Interactive profile ]
[ 5. Shopping list ]
```

Each demonstration has a **Back** button that returns to the main menu.

---

## 🎓 Learning Objectives

This project is designed as a beginner-friendly introduction to Jetpack Compose.

After working through the examples, you should have a better understanding of:

* How composable functions work
* How Compose layouts are created
* How state is stored and modified
* What causes recomposition
* How to handle user input
* How to conditionally display UI
* How to create interactive buttons
* How to build dynamic lists
* The difference between `remember` and `rememberSaveable`
* How Material 3 components can be used in an Android application

---

## 🔮 Possible Improvements

Future versions of the project could include:

* [ ] Improve the static profile demonstration with actual styling
* [ ] Add proper input validation messages
* [ ] Add a score maximum/minimum
* [ ] Add item editing to the shopping list
* [ ] Add confirmation before removing an item
* [ ] Persist the shopping list between app launches
* [ ] Add animations to demonstrate Compose state changes
* [ ] Add more Compose examples
* [ ] Add automated UI tests
* [ ] Improve accessibility and content descriptions
* [ ] Add screenshots and GIF demonstrations

---

## 📚 Key Compose APIs Used

| API                  | Purpose                                  |
| -------------------- | ---------------------------------------- |
| `@Composable`        | Defines a Compose UI function            |
| `Column`             | Arranges elements vertically             |
| `Row`                | Arranges elements horizontally           |
| `Text`               | Displays text                            |
| `Button`             | Creates an interactive button            |
| `OutlinedButton`     | Creates an outlined button               |
| `TextButton`         | Creates a text-based button              |
| `OutlinedTextField`  | Accepts user text input                  |
| `Card`               | Displays content inside a card           |
| `LazyColumn`         | Displays a scrollable list               |
| `Scaffold`           | Provides Material screen structure       |
| `TopAppBar`          | Displays a top application bar           |
| `remember`           | Retains state across recompositions      |
| `rememberSaveable`   | Retains saveable state across recreation |
| `mutableStateOf`     | Creates observable Compose state         |
| `mutableStateListOf` | Creates an observable mutable list       |

---

## 👨‍💻 Author

Created as a Kotlin and Jetpack Compose demonstration project.

---

## 📄 License

This project can be used for educational and learning purposes.
