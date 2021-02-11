package com.rationalstudio.movieapp.Repository

import com.rationalstudio.movieapp.ui.Api.RetrofitInstance
import com.rationalstudio.movieapp.ui.Database.MovieDatabase

class MovieRepository(
        val db:MovieDatabase
) {
    suspend fun getMovies() = RetrofitInstance.api.getMovies()
}