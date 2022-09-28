package com.example.knowledgeimprovement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.knowledgeimprovement.databinding.ItemMovieBinding
import com.example.knowledgeimprovement.model.domain.MovieDomainModel

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private val names = mutableListOf<MovieDomainModel>()

    fun addMovies(newNames: List<MovieDomainModel>) {
        names.clear()
        names.addAll(newNames)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount() = names.size
}

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieDomainModel) {
        binding.tvName.text = movie.title
    }
}