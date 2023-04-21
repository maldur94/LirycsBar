package com.maldur94.lirycsbar.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class LirycsBarActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen("World")
        }
    }
}

@Composable
fun WelcomeScreen(title: String) {
    Text(text = "Hello $title!")
}