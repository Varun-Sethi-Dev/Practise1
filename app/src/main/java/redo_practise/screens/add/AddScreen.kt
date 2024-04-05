package redo_practise.screens.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import redo_practise.db.Note

@Composable
fun AddScreen(addScreenVM: AddScreenViewModel1 = hiltViewModel<AddScreenViewModel1>()) {
    NoteEntryForm(note = addScreenVM._uiState.note, onValueChange = {
            addScreenVM.updateUiState(it)
    }, onSubmit = {
        addScreenVM.saveNote()
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NoteEntryForm(note: Note = Note(), onValueChange: (Note) -> Unit = {},
                  onSubmit:()->Unit={}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = note.heading,
            onValueChange = { onValueChange(note.copy(heading = it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            label = {
                Text(text = "Heading")
            }
            , singleLine = true,
        )
        TextField(value = note.message,
            onValueChange = { onValueChange(note.copy(message = it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            label = {
                Text(text = "Message")
            }
        )
        Button(onClick = { onSubmit() }) {
            Text(text = "Submit")
        }



    }
}