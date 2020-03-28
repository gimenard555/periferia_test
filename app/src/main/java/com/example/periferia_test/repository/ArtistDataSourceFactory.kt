package com.example.periferia_test.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.periferia_test.network.serializableobjects.ArtistData
import kotlinx.coroutines.CoroutineScope

class ArtistDataSourceFactory(private val scope: CoroutineScope) : DataSource.Factory<Int, ArtistData>() {

    private val artistLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, ArtistData>> = MutableLiveData()

    override fun create(): DataSource<Int, ArtistData> {
        val artistDataSource = ArtistDataSource(this.scope)
        this.artistLiveDataSource.postValue(artistDataSource)
        return artistDataSource
    }

    fun getArtistLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, ArtistData>> {
        return this.artistLiveDataSource
    }
}