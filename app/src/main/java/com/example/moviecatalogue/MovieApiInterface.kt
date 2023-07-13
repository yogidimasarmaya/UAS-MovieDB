package com.example.moviecatalogue

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=d76679c647cdfccc3e0171b1051a3713")
    fun getMovieList(): Call<MovieResponse>
}