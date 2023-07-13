package com.example.moviecatalogue

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv_show.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowFragment : Fragment() {
    var tvshow: List<TvShow>? = null
    private lateinit var tvAdapter: TvAdapter

    companion object {
        fun newInstance() = TvShowFragment()
    }

//    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        rv_tv_list.layoutManager = LinearLayoutManager(activity)
        rv_tv_list.setHasFixedSize(true)

        getTvData { tvshow: List<TvShow> ->
            rv_tv_list.adapter = TvAdapter(tvshow, object : TvAdapter.OnAdapterListener {
                override fun onClick(result: TvShow) {
                    val intent = Intent(activity, DetailTvActivity::class.java)
                    intent.putExtra(DetailTvActivity.EXTRA_DATA, result)
                    startActivity(intent)
                }
            })
        }
    }

    private fun setupRecyclerView(){
        tvAdapter = TvAdapter(arrayListOf(), object : TvAdapter.OnAdapterListener {
            override fun onClick(result: TvShow) { val intent = Intent(activity, DetailTvActivity::class.java)
                intent.putExtra(DetailTvActivity.EXTRA_DATA, result)
                startActivity(intent)
            }
        })
        rv_tv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = tvAdapter
        }
    }

    private fun getTvData(callback: (List<TvShow>) -> Unit){
        val apiService = ApiService.getInstance().create(TvApiInterface::class.java)
        apiService.getTvList().enqueue(object : Callback<TvResponse> {
            override fun onFailure(call: Call<TvResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                tvshow = response.body()!!.tvshow

                return callback(response.body()!!.tvshow)

            }
        })
    }
}