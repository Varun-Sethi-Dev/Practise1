package redo_practise.repository

import kotlinx.coroutines.flow.Flow
import redo_practise.db.Note

interface NotesRepository {
    suspend fun insert(note: Note)
    suspend fun delete(note: Note)
    suspend fun update(note: Note)
    fun getNoteWithId(id: Int): Flow<Note>
    fun getAllNotes(): Flow<List<Note>>
}