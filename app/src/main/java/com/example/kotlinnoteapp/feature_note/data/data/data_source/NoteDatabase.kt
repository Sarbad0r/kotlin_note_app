package com.example.kotlinnoteapp.feature_note.data.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinnoteapp.feature_note.domain.models.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDatabaseHelper: NoteDatabaseHelper

    companion object {
        val DATABASE_NAME: String = "notes.db"
    }
}