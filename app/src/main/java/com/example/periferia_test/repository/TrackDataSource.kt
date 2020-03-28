package com.example.periferia_test.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.periferia_test.network.retrofit.RetrofitClient
import com.example.periferia_test.network.serializableobjects.TrackData
import com.example.periferia_test.network.services.GeoTopTracks
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class TrackDataSource(private val scope: CoroutineScope) : PageKeyedDataSource<Int, TrackData>() {

    val PAGE_SIZE = 20
    private val FIRST_PAGE = 1
    private var geoTopTracks: GeoTopTracks = RetrofitClient.createService(GeoTopTracks::class.java)

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, TrackData>) {
        this.scope.launch {
            try {
                val response = geoTopTracks.getTopTracks(country = "spain")
                when {
                    response.isSuccessful -> {
                        //callback.onResult(response.body()!!.topArtist ?: listOf(), null, FIRST_PAGE + 1)
                    }
                }
            } catch (exception: Exception) {
                Log.e("PostDataSource", "Failed to fetch data! - " + exception.message)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, TrackData>) {
        this.scope.launch {
            try {
                val response = geoTopTracks.getTopTracks(country = "spain");

                when {
                    response.isSuccessful -> {
                        val key: Int?
                        /* if (response.body()?.isNotEmpty()!!) key = params.key + 1
                         else key = null
                         callback.onResult(response.body()!!, key)*/
                    }
                }
            } catch (exception: Exception) {
                Log.e("PostDataSource", "Failed to fetch data!(LoadAfter) - " + exception.message)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, TrackData>) {
        scope.launch {
            try {
                val response = geoTopTracks.getTopTracks(country = "spain");
                val key: Int?
                if (params.key > 1) key = params.key - 1
                else key = null
                when {
                    response.isSuccessful -> {
                        //     callback.onResult(response.body()!!, key)
                    }
                }
            } catch (exception: Exception) {
                Log.e("PostDataSource", "Failed to fetch data!(LoadBefore) - " + exception.message)
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        this.scope.cancel()
    }
}