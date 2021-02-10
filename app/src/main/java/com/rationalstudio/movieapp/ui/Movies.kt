package com.rationalstudio.movieapp.ui
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


@Entity(
    
)
data class Movies (
    val title: String,
    val urlToImage: String
)