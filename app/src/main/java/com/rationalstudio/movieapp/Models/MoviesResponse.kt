package com.rationalstudio.movieapp.ui.Models

import com.rationalstudio.movieapp.ui.Models.Movies

data class MoviesResponse (
        val movies: List<Movies>,
        val status: String
)