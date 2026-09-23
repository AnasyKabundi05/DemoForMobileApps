package com.example.mobileappdemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.mobileappdemos.exercise.Exercise2Counter
import com.example.mobileappdemos.exercise.Exercise3NameInput
import com.example.mobileappdemos.exercise.Exercise4InteractiveProfile
import com.example.mobileappdemos.exercise.Exercise5ShoppingList
import com.example.mobileappdemos.ui.theme.MobileappdemosTheme

import com.example.mobileappdemos.exercise.StaticProfile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileappdemosTheme {


                    Surface{
                        StaticProfile()
                    }

                    Surface{
                        Exercise2Counter()
                    }

                    Surface {
                        Exercise3NameInput()
                    }

                Surface {
                    Exercise4InteractiveProfile()
                }

                Surface {
                    Exercise5ShoppingList()
                }

            }
        }
    }
}

