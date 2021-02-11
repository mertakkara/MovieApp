package com.rationalstudio.movieapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rationalstudio.movieapp.Repository.MovieRepository
import com.rationalstudio.movieapp.ui.Models.MoviesResponse
import com.rationalstudio.movieapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MoviesViewModel(
val movieRepository: MovieRepository
):ViewModel() {
    val movies : MutableLiveData<Resource<MoviesResponse>> = MutableLiveData()

    init {
        getMovies()
    }

    fun getMovies() = viewModelScope.launch {
        movies.postValue(Resource.Loading())
        val response = movieRepository.getMovies()
        movies.postValue(handleMoviesResponse(response))
    }
    private fun handleMoviesResponse(response: Response<MoviesResponse>) : Resource<MoviesResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}