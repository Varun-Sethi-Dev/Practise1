package redo_practise.repository

import kotlinx.coroutines.flow.Flow
import redo_practise.db.Note
import redo_practise.db.NotesDao
import javax.inject.Inject

class OfflineNotesRepository @Inject constructor(private val dao: NotesDao) : NotesRepository {
    override suspend fun insert(note: Note) {
        dao.insert(note)
    }

    override suspend fun delete(note: Note) {
        dao.delete(note)
    }

    override suspend fun update(note: Note) {
        dao.update(note)
    }

    override fun getNoteWithId(id: Int): Flow<Note> {
        return dao.getNoteWithId(id)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }
}