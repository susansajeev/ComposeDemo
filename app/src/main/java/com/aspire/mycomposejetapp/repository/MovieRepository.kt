package com.aspire.mycomposejetapp.repository

import com.aspire.mycomposejetapp.di.ApiService
import com.aspire.mycomposejetapp.model.User
import com.aspire.mycomposejetapp.model.entity.MovieDeo
import com.aspire.mycomposejetapp.model.entity.MovieTB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDeo: MovieDeo, private val apiService: ApiService){
     suspend fun addMoview(movie: MovieTB){
         movieDeo.insert(movie)
     }

    suspend fun deleteMoview(movie: MovieTB){
        movieDeo.delete(movie)
    }

    suspend fun getAllMoview() : Flow<List<MovieTB>> {
       return movieDeo.getAllPersons().flowOn(Dispatchers.IO).conflate()
    }

    suspend fun getUsers(): Response<List<User>> {
        return apiService.getUsers()
    }
}