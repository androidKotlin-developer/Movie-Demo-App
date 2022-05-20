package com.example.movie_demo.data

import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieData>,
    @SerializedName("total_pages") val pages: Int
)