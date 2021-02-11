package com.rationalstudio.movieapp.ui.Api

import com.rationalstudio.movieapp.ui.Models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("/movies.php")
    suspend fun getMovies(): Response<MoviesResponse>


}