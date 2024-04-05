package redo_practise.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import redo_practise.db.Note
import redo_practise.repository.NotesRepository
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {
        var listOfNotes = MutableStateFlow(listOf(Note()))
    fun getAllNotes(): MutableStateFlow<List<Note>> {
        viewModelScope.launch {
            listOfNotes.value = notesRepository.getAllNotes().filterNotNull().first()
        }
        return listOfNotes
    }
    init {
        getAllNotes()
    }
}