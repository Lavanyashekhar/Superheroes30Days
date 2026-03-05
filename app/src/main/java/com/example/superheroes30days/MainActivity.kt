package com.example.superheroes30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.superheroes30days.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SuperheroesTheme {
                SuperheroesApp()
            }
        }
    }
}