package com.example.periferia_test.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.periferia_test.R
import com.example.periferia_test.viewmodel.TopArtistViewModel
import com.example.periferia_test.viewmodel.TopTrackViewModel
import com.example.periferia_test.views.adapters.TopArtistAdapter
import com.example.periferia_test.views.adapters.TopTrackAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //private val topArtistAdapter = TopArtistAdapter()
    private val trackAdapter = TopTrackAdapter()
    private lateinit var topTrackViewModel: TopTrackViewModel
    private lateinit var topArtistViewModel: TopArtistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.topArtistViewModel = ViewModelProviders.of(this).get(TopArtistViewModel::class.java)
        this.topTrackViewModel = ViewModelProviders.of(this).get(TopTrackViewModel::class.java)
        observeLiveData()
        initViews()
    }


    private fun initViews() {
        top_artist_list.layoutManager = LinearLayoutManager(this)
        top_artist_list.adapter = this.trackAdapter
    }


    private fun observeLiveData() {
        this.topTrackViewModel.trackPagedList!!.observe(this, Observer {
            trackAdapter.submitList(it)
        })
    }
}