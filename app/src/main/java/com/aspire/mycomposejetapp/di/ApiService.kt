package com.aspire.mycomposejetapp.di

import com.aspire.mycomposejetapp.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}