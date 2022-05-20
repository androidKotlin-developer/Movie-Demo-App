package com.example.movie_demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movie_demo.R
import com.example.movie_demo.data.MovieData

class MoviesAdapter(private var movies : List<MovieData> , var clickListner: OnItemClickListner) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_design, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.initialize(movies.get(position),clickListner)
    }

    fun updateMovies(movies: List<MovieData>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tittle : TextView = itemView.findViewById(R.id.title_template)
        val desc : TextView = itemView.findViewById(R.id.movie_description)

        private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)

        fun bind(movie: MovieData) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                .transform(CenterCrop())
                .into(poster)
            tittle.text = movie.title
            desc.text = movie.overview
        }

        fun initialize(item: MovieData, action: OnItemClickListner) {
            itemView.setOnClickListener{
                action.onItemClick(item,adapterPosition)
            }

        }
    }

    interface OnItemClickListner {
        fun onItemClick(item: MovieData, position: Int)
    }

}