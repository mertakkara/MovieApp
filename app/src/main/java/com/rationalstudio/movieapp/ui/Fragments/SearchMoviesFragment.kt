package com.rationalstudio.movieapp.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.ui.MainActivity
import com.rationalstudio.movieapp.ui.MoviesViewModel

class SearchMoviesFragment: Fragment(R.layout.saved_movies_fragment) {
    lateinit var viewModel: MoviesViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel


    }
}