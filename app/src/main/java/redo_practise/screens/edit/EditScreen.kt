package redo_practise.screens.edit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collect
import redo_practise.screens.list.NoteCard

@Composable
fun EditScreen(noteId: Int?, edSCVm: EditScreenViewModel = hiltViewModel<EditScreenViewModel>()) {
    LaunchedEffect(noteId) {
        noteId?.let {
            edSCVm.getNoteWithId(it)
        }
    }
    val note = edSCVm.note.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        if (noteId != null) {
            NoteCard(
                note = note,
                modifier = Modifier.clickable {
                })
        } else {
            Text(text = "Note ID was null")
        }
    }
}
//@Composable
//fun EditScreen(noteId: Int?, edSCVm: EditScreenViewModel = hiltViewModel<EditScreenViewModel>()) {
//    LaunchedEffect(noteId) {
//        noteId?.let { edSCVm.getNoteWithId(it) }
//    }
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top
//    ) {
//        val note = edSCVm.note.collectAsState().value
//        if (noteId != null && note != null) {
//            NoteCard(
//                note = note,
//                modifier = Modifier.clickable {
//                })
//        } else {
//            Text(text = "Note ID was null")
//        }
//    }
//}