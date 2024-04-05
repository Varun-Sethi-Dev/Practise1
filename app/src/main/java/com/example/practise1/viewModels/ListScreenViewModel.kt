package com.example.practise1.viewModels

import androidx.lifecycle.ViewModel
import com.example.practise1.db.NotesDao
import javax.inject.Inject

class ListScreenViewModel @Inject constructor(private val dao: NotesDao) : ViewModel() {
}