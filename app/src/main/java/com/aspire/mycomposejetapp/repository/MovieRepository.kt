package com.aspire.mycomposejetapp.repository

import com.aspire.mycomposejetapp.model.entity.MovieDeo
import com.aspire.mycomposejetapp.model.entity.MovieTB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDeo: MovieDeo){
     suspend fun addMoview(movie: MovieTB){
         movieDeo.insert(movie)
     }

    suspend fun deleteMoview(movie: MovieTB){
        movieDeo.delete(movie)
    }

    suspend fun getAllMoview() : Flow<List<MovieTB>> {
       return movieDeo.getAllPersons().flowOn(Dispatchers.IO).conflate()
    }
}