package redo_practise.screens.edit

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
class EditScreenViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {
    fun getNoteWithId(id: Int): StateFlow<Note> {
        lateinit var note: StateFlow<Note>
        viewModelScope.launch {
            note = notesRepository.getNoteWithId(id).stateIn(
                viewModelScope,
                SharingStarted.Lazily,
                Note()
            )
        }
        return note

    }
}