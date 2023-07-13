package com.example.moviecatalogue

import retrofit2.Call
import retrofit2.http.GET

interface TvApiInterface {

    @GET("/3/tv/popular?api_key=d76679c647cdfccc3e0171b1051a3713")
    fun getTvList(): Call<TvResponse>
}