package com.aspire.mycomposejetapp.screens.home.prelogin

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aspire.mycomposejetapp.model.Movie
import com.aspire.mycomposejetapp.model.User
import com.aspire.mycomposejetapp.model.entity.MovieTB
import com.aspire.mycomposejetapp.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    //val moviesDetail  = mutableStateListOf<Movie>()

    private val _movieList = MutableStateFlow<List<MovieTB>>(emptyList())
    val movieList = _movieList.asStateFlow()

    private val _userResp = MutableLiveData<Response<List<User>>>()
    val userResp: LiveData<Response<List<User>>> get() = _userResp

    init {
        getAllMovieChanges()
        getAllUsers()
    }

    fun DeleteDta( movie: MovieTB) {

        viewModelScope.launch {
            repository.deleteMoview(movie)
        }

    }
    fun addData(s: String, s2: String) {
        var movie = MovieTB(0,s,  s2)
        viewModelScope.launch {
            repository.addMoview(movie)
        }
//        Log.d("Movie=== $s2", s)
//
//        moviesDetail.add(movie)
    }

    fun getAllMovieChanges(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllMoview().distinctUntilChanged().collect{
                _movieList.value = it
            }
        }

    }
    fun getAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getUsers()
            _userResp.value = res
            Log.d("Susan ","size====="+userResp.value!!.body()!!.size)
        }

    }
}