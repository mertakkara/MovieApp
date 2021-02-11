package com.rationalstudio.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.Repository.MovieRepository
import com.rationalstudio.movieapp.ui.Database.MovieDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MoviesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movieRepository = MovieRepository(MovieDatabase(this))
        val viewModelProviderFactory = MoviesViewModelProviderFactory(movieRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MoviesViewModel::class.java)
        bottomNavigationView.setupWithNavController(NavHostFragment.findNavController())
    }
}