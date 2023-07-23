package com.example.kotlinnoteapp.feature_note.data.data.data_source

import androidx.room.*
import com.example.kotlinnoteapp.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseHelper {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>;

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNotById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete()
    suspend fun deleteNote(note: Note)
}