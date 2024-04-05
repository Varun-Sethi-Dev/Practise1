package redo_practise.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import redo_practise.db.NotesDatabase
import redo_practise.repository.NotesRepository
import redo_practise.repository.OfflineNotesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context = context,
            NotesDatabase::class.java,
            "Notes Database"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideNotesRepository(db: NotesDatabase): NotesRepository {
        return OfflineNotesRepository(dao = db.getNotesDao())
    }
}