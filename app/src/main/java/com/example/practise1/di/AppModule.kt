package com.example.practise1.di

import android.content.Context
import androidx.room.Room
import com.example.practise1.db.NotesDao
import com.example.practise1.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NotesDatabase {
        return Room.databaseBuilder(
            context = context,
            NotesDatabase::class.java,
            "notesDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: NotesDatabase): NotesDao {
        return db.getDao()
    }

}