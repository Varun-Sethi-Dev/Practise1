package com.example.practise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.practise1.navigationManager.NavManager
import com.example.practise1.ui.theme.Practise1Theme
import dagger.hilt.android.AndroidEntryPoint
import redo_practise.NotesApp1

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practise1Theme {
                // A surface container using the 'background' color from the theme
                //val navController = rememberNavController()
                NotesApp1()
            }
        }
    }
}
