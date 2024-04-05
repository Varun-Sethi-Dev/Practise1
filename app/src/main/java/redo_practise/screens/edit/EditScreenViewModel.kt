package redo_practise.screens.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import redo_practise.db.Note
import redo_practise.repository.NotesRepository
import javax.inject.Inject

@HiltViewModel
class EditScreenViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {
        var note = MutableStateFlow<Note>(Note())
    fun getNoteWithId(id: Int): MutableStateFlow<Note> {
        viewModelScope.launch {
            note.value = notesRepository.getNoteWithId(id).filterNotNull().first()
        }
        return note

    }

}
