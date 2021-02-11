package com.rationalstudio.movieapp.Repository

import android.app.DownloadManager
import com.rationalstudio.movieapp.ui.Api.RetrofitInstance
import com.rationalstudio.movieapp.ui.Database.MovieDatabase
import com.rationalstudio.movieapp.ui.Models.Movies

class MovieRepository(
        val db:MovieDatabase
) {
    suspend fun getMovies() = RetrofitInstance.api.getMovies()
    suspend fun upsert(movie:Movies) = db.getMovieDao().upsert(movie)
    fun getAllMovies( ) = db.getMovieDao().getAllMovies()
    suspend fun deleteMovie(movie:Movies) = db.getMovieDao().deleteMovie(movie)

}