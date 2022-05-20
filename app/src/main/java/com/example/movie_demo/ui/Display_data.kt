package com.example.movie_demo.ui


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movie_demo.R
import com.example.movie_demo.data.MovieData

class Display_data : AppCompatActivity() {

lateinit var movieData: MovieData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)
        supportActionBar?.hide()



        val tittle_display = findViewById<TextView>(R.id.tittle_display)
        val release_date = findViewById<TextView>(R.id.release_date)
        val movie_dsc = findViewById<TextView>(R.id.movie_desc)
        val imageView: ImageView = findViewById(R.id.display_img)


        Log.d("Display","Image" + imageView )

        //imageView.setImageURI(Uri.parse("https://image.tmdb.org/t/p/w300_and_h450_bestv2/" +{movieData.backdropPath} ))

        Glide.with(this).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2/" + getIntent().getStringExtra("posterPath")).into(imageView)
        tittle_display.text = getIntent().getStringExtra("title")
        release_date.text = getIntent().getStringExtra("releaseDate")
        movie_dsc.text = getIntent().getStringExtra("overview")

    }
}