package com.rationalstudio.movieapp.ui.Api

import com.rationalstudio.movieapp.ui.Movies
import com.rationalstudio.movieapp.ui.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movies.php")
    suspend fun getMovies(): Response<MoviesResponse>

    @GET("/movies.php")
    suspend fun searchMovies(): Response<MoviesResponse>
}