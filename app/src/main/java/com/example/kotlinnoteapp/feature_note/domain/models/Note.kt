package com.example.kotlinnoteapp.feature_note.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlinnoteapp.ui.theme.*
import java.sql.Timestamp

//if we want use room database for model use @Entity
@Entity
data class Note(
    val title: String,
    val context: String,
    val timestamp: Long,
    val Color: Int,
    //id for room database
    @PrimaryKey val id: Int? = null,
) {
    companion object {
        val notColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}