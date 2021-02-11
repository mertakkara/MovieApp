package com.rationalstudio.movieapp.ui.Models
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


@Entity(
        tableName = "movies"
)
data class Movies (
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null,
    val title: String,
    val description: String,
    val urlToImage: String
):Serializable