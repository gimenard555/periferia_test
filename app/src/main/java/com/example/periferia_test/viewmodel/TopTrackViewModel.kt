package com.example.periferia_test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.periferia_test.network.serializableobjects.TrackData
import com.example.periferia_test.repository.TrackDataSource
import com.example.periferia_test.repository.TrackDataSourceFactory

class TopTrackViewModel : ViewModel() {

    var trackPagedList: LiveData<PagedList<TrackData>>? = null
    private var trackLiveDataSource: LiveData<PageKeyedDataSource<Int, TrackData>>? = null

    init {
        val trackDataSourceFactory = TrackDataSourceFactory(viewModelScope)
        this.trackLiveDataSource = trackDataSourceFactory.getTrackLiveDataSource()

        val config: PagedList.Config = (PagedList.Config.Builder()).setEnablePlaceholders(false)
            .setPageSize(TrackDataSource(viewModelScope).PAGE_SIZE).build()

        this.trackPagedList = LivePagedListBuilder(trackDataSourceFactory, config).build()
    }

}