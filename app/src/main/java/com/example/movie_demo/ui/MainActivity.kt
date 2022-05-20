package com.example.movie_demo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_demo.R
import com.example.movie_demo.adapter.MoviesAdapter
import com.example.movie_demo.data.MovieData
import com.example.movie_demo.retrofit.MoviesRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()  , MoviesAdapter.OnItemClickListner {

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        popularMovies = findViewById(R.id.popular_movies)
        bottomNavigationView =findViewById(R.id.bottomNavigationView)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularMoviesAdapter = MoviesAdapter(listOf(),this)
        popularMovies.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )


    }

    private fun onPopularMoviesFetched(movies: List<MovieData>) {
        popularMoviesAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(this, "error found", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(item: MovieData, position: Int) {
        val intent = Intent(this, Display_data::class.java)
        intent.putExtra("title", item.title)
        intent.putExtra("releaseDate", item.releaseDate)
        intent.putExtra("overview", item.overview)
        intent.putExtra("posterPath", item.posterPath)

        startActivity(intent)

    }


}