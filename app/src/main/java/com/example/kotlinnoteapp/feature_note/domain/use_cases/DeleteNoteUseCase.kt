package com.example.kotlinnoteapp.feature_note.domain.use_cases

import com.example.kotlinnoteapp.feature_note.domain.models.Note
import com.example.kotlinnoteapp.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note = note)
    }
}