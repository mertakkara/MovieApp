package com.rationalstudio.movieapp.ui.Models

import com.rationalstudio.movieapp.ui.Models.Movies

data class MoviesResponse (
    val articles: List<Movies>,
    val status: String,
    val totalResults: Int
)