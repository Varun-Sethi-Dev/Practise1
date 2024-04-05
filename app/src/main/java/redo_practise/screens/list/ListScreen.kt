package redo_practise.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import redo_practise.db.Note

@Preview(showBackground = true)
@Composable
fun ListScreen(
    listScVm: ListScreenViewModel = hiltViewModel<ListScreenViewModel>(),
    navigateToEditScreen: (Int) -> Unit = {},
) {
    val notesList = listScVm.getAllNotes().collectAsState()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        items(items = notesList.value) { note ->
            NoteCard(note = note, modifier = Modifier.clickable {
                navigateToEditScreen(note.id)
            })
        }
    }
}

@Preview
@Composable
fun NoteCard(modifier: Modifier = Modifier, note: Note = Note()) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${note.id}",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 20.sp
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = note.heading,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = note.message,
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}