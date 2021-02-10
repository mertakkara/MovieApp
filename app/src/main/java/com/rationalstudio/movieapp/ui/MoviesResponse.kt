package com.rationalstudio.movieapp.ui

data class MoviesResponse (
    val articles: List<Movies>,
    val status: String,
    val totalResults: Int
)