package com.example.periferia_test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.periferia_test.network.serializableobjects.ArtistData
import com.example.periferia_test.repository.ArtistDataSource
import com.example.periferia_test.repository.ArtistDataSourceFactory

class TopArtistViewModel : ViewModel() {

    var artistPagedList: LiveData<PagedList<ArtistData>>? = null
    private var artistLiveDataSource: LiveData<PageKeyedDataSource<Int, ArtistData>>? = null

    init {
        val postDataSourceFactory = ArtistDataSourceFactory(viewModelScope)
        artistLiveDataSource = postDataSourceFactory.getArtistLiveDataSource()

        val config: PagedList.Config = (PagedList.Config.Builder()).setEnablePlaceholders(false)
            .setPageSize(ArtistDataSource(viewModelScope).PAGE_SIZE).build()

        artistPagedList = LivePagedListBuilder(postDataSourceFactory, config).build()
    }

}