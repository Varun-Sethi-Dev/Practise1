package com.example.practise1.viewModels

import com.example.practise1.db.Note

data class NoteUiState(
    val id:Int =0,
    val note:Note = Note()
)