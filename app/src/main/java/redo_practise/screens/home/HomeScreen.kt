package redo_practise.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    navigateToListScreen: () -> Unit,
    navigateToAddScreen: () -> Unit,
    navigateToEditScreen: () -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Notes App")
        Button(onClick = { navigateToEditScreen() }) {
            Text("Edit Notes")
        }
        Button(onClick = { navigateToAddScreen() }) {
            Text("Add a Note")
        }
        Button(onClick = { navigateToListScreen() }) {
            Text("View List of All Notes")
        }
    }

}