package redo_practise.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import redo_practise.db.Note
import redo_practise.repository.NotesRepository
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {
    fun getAllNotes(): StateFlow<List<Note>> {
        lateinit var notelist: StateFlow<List<Note>>
        viewModelScope.launch {
            notelist = notesRepository.getAllNotes().stateIn(
                viewModelScope,
                SharingStarted.Lazily,
                listOf<Note>()
            )
        }
        return notelist
    }
}