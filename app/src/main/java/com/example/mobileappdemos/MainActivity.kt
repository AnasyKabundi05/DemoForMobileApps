package com.example.mobileappdemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.mobileappdemos.ui.theme.MobileAppDemosTheme
import com.example.mobileappdemos.demos.MobileAppDemos
import com.example.mobileappdemos.ui.theme.MobileAppDemosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileAppDemosTheme() {

                Surface {

                    MobileAppDemos()

                }


            }
        }
    }
}

