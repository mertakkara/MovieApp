package com.rationalstudio.movieapp.ui.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.ui.Adapters.MovieAdapter
import com.rationalstudio.movieapp.ui.MainActivity
import com.rationalstudio.movieapp.ui.MoviesViewModel
import com.rationalstudio.movieapp.util.Resource
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment: Fragment(R.layout.movies_fragment) {


    lateinit var viewModel: MoviesViewModel

    lateinit var movieAdapter : MovieAdapter

    val TAG = "myTag"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.movies.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { moviesResponse ->
                        Log.e(TAG, "An error occured: ")
                        movieAdapter.differ.submitList(moviesResponse.movies)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    Log.e(TAG, "An error occured:")
                    showProgressBar()
                }
            }
        })


    }
    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        movieAdapter = MovieAdapter()

        rvMovies.apply {

            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)
            Log.e(TAG, "An error occured2123:")
        }
    }

}