package redo_practise.screens.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import redo_practise.db.Note
import redo_practise.repository.NotesRepository
import redo_practise.screens.uiState.noteUiState
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel1 @Inject constructor(private val repository: NotesRepository) :
    ViewModel() {
    val scope = viewModelScope
    var _uiState by mutableStateOf(noteUiState())
        private set

    fun updateUiState(newNote: Note) {
        _uiState = _uiState.copy(note = newNote)
    }

    fun saveNote() {
        scope.launch(context = Dispatchers.IO) {
            repository.insert(_uiState.note)
        }
    }
}