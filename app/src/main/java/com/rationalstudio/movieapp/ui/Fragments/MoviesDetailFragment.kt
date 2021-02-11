package com.rationalstudio.movieapp.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.ui.MainActivity
import com.rationalstudio.movieapp.ui.MoviesViewModel

class MoviesDetailFragment: Fragment(R.layout.movies_fragment) {
  lateinit var viewModel: MoviesViewModel
   // val args: MoviesDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        //val movie = args.movie



    }
}