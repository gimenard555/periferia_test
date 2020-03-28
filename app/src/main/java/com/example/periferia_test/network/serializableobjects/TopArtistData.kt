package com.example.periferia_test.network.serializableobjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TopArtistData {

    @SerializedName(TOP_ARTIST_LIST)
    @Expose
    var topArtist: List<ArtistData>? = null

    companion object {
        const val TOP_ARTIST_LIST = "artist"
    }
}