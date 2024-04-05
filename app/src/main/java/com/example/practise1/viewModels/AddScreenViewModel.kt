package com.example.practise1.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practise1.db.Note
import com.example.practise1.db.NotesDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(private val dao: NotesDao) : ViewModel() {
    var _uiState by mutableStateOf(NoteUiState())
        private set

    fun updateUI(note: Note) {
        _uiState = _uiState.copy(note = note)
    }

    suspend fun saveNote() {
        dao.addNote(note = _uiState.note)
    }
}