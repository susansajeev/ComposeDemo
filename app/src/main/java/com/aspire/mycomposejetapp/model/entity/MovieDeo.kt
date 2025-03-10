package com.aspire.mycomposejetapp.model.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDeo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: MovieTB)

    @Update
    suspend fun update(person: MovieTB)

    @Delete
    suspend fun delete(person: MovieTB)

    @Query("SELECT * FROM movie_tb ORDER BY id ASC")
    suspend fun getAllPersons(): Flow<List<MovieTB>>
}