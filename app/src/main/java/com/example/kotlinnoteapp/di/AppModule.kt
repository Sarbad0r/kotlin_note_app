package com.example.kotlinnoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.kotlinnoteapp.NoteApp
import com.example.kotlinnoteapp.feature_note.data.data.data_source.NoteDatabase
import com.example.kotlinnoteapp.feature_note.data.data.repository.NoteRepositoryImpl
import com.example.kotlinnoteapp.feature_note.domain.repository.NoteRepository
import com.example.kotlinnoteapp.feature_note.domain.use_cases.DeleteNoteUseCase
import com.example.kotlinnoteapp.feature_note.domain.use_cases.GetNotesUseCase
import com.example.kotlinnoteapp.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME)
            .build();
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDatabaseHelper)
    }


    @Provides
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository))
    }
}