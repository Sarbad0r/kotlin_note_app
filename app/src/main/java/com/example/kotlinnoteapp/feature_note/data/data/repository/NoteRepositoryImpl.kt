package com.example.kotlinnoteapp.feature_note.data.data.repository

import androidx.room.Dao
import com.example.kotlinnoteapp.feature_note.data.data.data_source.NoteDatabaseHelper
import com.example.kotlinnoteapp.feature_note.domain.models.Note
import com.example.kotlinnoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val databaseHelper: NoteDatabaseHelper) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return databaseHelper.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return databaseHelper.getNotById(id = id)
    }

    override suspend fun insertNote(note: Note) {
        databaseHelper.insertNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        databaseHelper.deleteNote(note = note)
    }
}