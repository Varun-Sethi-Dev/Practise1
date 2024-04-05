package com.example.practise1.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateNote(note: Note)
    @Query("select * from Notes where id = :id")
    fun getNote(id:Int): Flow<Note>
    @Query("SELECT * FROM Notes")
    fun getAllNotes(): Flow<List<Note>>
}