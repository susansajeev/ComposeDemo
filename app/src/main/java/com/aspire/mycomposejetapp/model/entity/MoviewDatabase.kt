package com.aspire.mycomposejetapp.model.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieTB::class], version = 1, exportSchema = false)
abstract class MoviewDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDeo

    
}