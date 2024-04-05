package com.example.practise1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.practise1.db.Note
import com.example.practise1.viewModels.AddScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Preview
@Composable
fun AddScreen(addScVM: AddScreenViewModel = hiltViewModel<AddScreenViewModel>()) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = addScVM._uiState.note.content, onValueChange = {
            addScVM.updateUI(Note(content = it))
        }, modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            coroutineScope.launch {
                withContext(Dispatchers.IO) {
                    addScVM.saveNote()
                }
            }
        }) {
            Text(text = "Submit")
        }
    }

}