package com.aspire.mycomposejetapp.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("movie_tb")
data class MovieTB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val writer: String
)
