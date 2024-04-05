package com.example.practise1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

sealed class Button(val name:String){
    data object Add:Button(name = "add")
    data object Read:Button(name = "list")
    data object Edit:Button(name = "edit")
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onButtonClick: (Button) -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {onButtonClick(Button.Add)}
        ) {
            Text(text = "Add Note")
        }
        Button(onClick = { onButtonClick(Button.Read) }) {
            Text(text = "List Note")
        }
        Button(onClick = { onButtonClick(Button.Edit) }) {
            Text(text = "Edit Note")
        }
    }
}