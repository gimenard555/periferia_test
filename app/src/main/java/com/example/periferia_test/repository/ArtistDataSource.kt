package com.example.periferia_test.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.periferia_test.network.retrofit.RetrofitClient
import com.example.periferia_test.network.serializableobjects.ArtistData
import com.example.periferia_test.network.serializableobjects.TopArtistData
import com.example.periferia_test.network.services.GeoTopArtists
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception

class ArtistDataSource(private val scope: CoroutineScope) : PageKeyedDataSource<Int, ArtistData>() {

    val PAGE_SIZE = 20
    private val FIRST_PAGE = 1
    private var geoTopArtists: GeoTopArtists = RetrofitClient.createService(GeoTopArtists::class.java)

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ArtistData>) {
        this.scope.launch {
            try {
                val response = geoTopArtists.getTopArtists(country ="spain")
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

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArtistData>) {
        this.scope.launch {
            try {
                val response = geoTopArtists.getTopArtists(country = "spain");

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

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArtistData>) {
        scope.launch {
            try {
                val response = geoTopArtists.getTopArtists(country ="spain");
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