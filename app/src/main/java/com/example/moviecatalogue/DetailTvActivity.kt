package com.example.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.img_poster
import kotlinx.android.synthetic.main.activity_detail_movie.overview
import kotlinx.android.synthetic.main.activity_detail_tv.*
import kotlinx.android.synthetic.main.movie_item.*

class DetailTvActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    var tvshow: TvShow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        tvshow = intent.getParcelableExtra(EXTRA_DATA)

        tv_name.text = tvshow?.name
        overview.text = tvshow?.overview
        Glide.with(img_poster).load(IMAGE_BASE + tvshow!!.poster_path).into(img_poster)
    }
}