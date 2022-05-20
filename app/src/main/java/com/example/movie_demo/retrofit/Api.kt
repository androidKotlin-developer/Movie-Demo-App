package com.example.movie_demo.retrofit


import com.example.movie_demo.data.GetMoviesResponse
import com.example.movie_demo.data.MovieData


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular?")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "139ef56240afce7df7f4727dd69524a4",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}
