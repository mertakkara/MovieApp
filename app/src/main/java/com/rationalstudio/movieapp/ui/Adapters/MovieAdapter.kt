package com.rationalstudio.movieapp.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rationalstudio.movieapp.R
import com.rationalstudio.movieapp.ui.Models.Movies
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Movies>(){
        override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem.urlToImage == newItem.urlToImage

        }

        override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_movie,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(movie.urlToImage).into(ivArticleImage)

            tvTitle.text = movie.title
            tvDescription.text = movie.description

            setOnClickListener {
                onItemClickListener?.let { it(movie) }
            }
        }
    }
    private var onItemClickListener: ((Movies) -> Unit)? = null

    fun setOnItemClickListener(listener: (Movies) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }
}