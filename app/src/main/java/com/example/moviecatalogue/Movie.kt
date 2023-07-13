package com.example.moviecatalogue

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable
//    @SerializedName("id")
//    val id : String?,
//
//    @SerializedName("title")
//    val title : String?,
//
//    @SerializedName("poster_path")
//    val poster : String?,
//
//    @SerializedName("release_date")
//    val release : String?

//) : Parcelable