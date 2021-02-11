package com.rationalstudio.movieapp.ui.Database

import androidx.room.TypeConverter
import com.rationalstudio.movieapp.ui.Models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}