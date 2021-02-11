package com.rationalstudio.movieapp.ui.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rationalstudio.movieapp.ui.Models.Movies


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(movie: Movies): Long

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<Movies>>

    @Delete
    suspend fun deleteMovie(movie: Movies)
}