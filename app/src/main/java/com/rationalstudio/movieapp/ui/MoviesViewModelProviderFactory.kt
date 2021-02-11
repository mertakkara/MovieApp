package com.rationalstudio.movieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rationalstudio.movieapp.Repository.MovieRepository

class MoviesViewModelProviderFactory(
        val movieRepository: MovieRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(movieRepository) as T
    }
}