package com.example.periferia_test.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.periferia_test.network.serializableobjects.TrackData
import kotlinx.coroutines.CoroutineScope

class TrackDataSourceFactory(private val scope: CoroutineScope) : DataSource.Factory<Int, TrackData>() {

    private val trackLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, TrackData>> = MutableLiveData()

    override fun create(): DataSource<Int, TrackData> {
        val trackDataSource = TrackDataSource(this.scope)
        this.trackLiveDataSource.postValue(trackDataSource)
        return trackDataSource
    }

    fun getTrackLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, TrackData>> {
        return this.trackLiveDataSource
    }
}