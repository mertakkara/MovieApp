package com.rationalstudio.movieapp.ui.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.ui.Adapters.MovieAdapter
import com.rationalstudio.movieapp.ui.MainActivity
import com.rationalstudio.movieapp.ui.MoviesViewModel
import kotlinx.android.synthetic.main.saved_movies_fragment.*
import kotlinx.android.synthetic.main.search_movies_fragment.*

class SavedMoviesFragment: Fragment(R.layout.saved_movies_fragment) {
    lateinit var viewModel: MoviesViewModel

    lateinit var movieAdapter : MovieAdapter

    val TAG = "myTag"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

       /* movieAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("movie",it)
            }
            findNavController().navigate(
                R.id.action_savedMoviesFragment_to_moviesDetailFragment,
                bundle
            )
        }*/

    val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return  true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val movie = movieAdapter.differ.currentList[position]
            viewModel.deleteMovie(movie)
            Snackbar.make(view,"Deleted Movie",Snackbar.LENGTH_LONG).apply {
                setAction("Undo"){
                    viewModel.saveMovie(movie)

                }
                show()
            }
        }

    }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(rvSavedMovies)
        }

    viewModel.getSavedMovies().observe(viewLifecycleOwner, Observer {movies->
        movieAdapter.differ.submitList(movies)

    })


    }
    private fun setupRecyclerView() {
        movieAdapter = MovieAdapter()

        rvSavedMovies.apply {

            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }
}