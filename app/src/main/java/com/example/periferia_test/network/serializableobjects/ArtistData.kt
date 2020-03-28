package com.example.periferia_test.network.serializableobjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArtistData(
    @SerializedName(ARTIST_NAME)
    @Expose
    var artistName: String? = null,

    @SerializedName(ARTIST_LISTENERS)
    @Expose
    var artistListeners: String? = null,

    @SerializedName(ARTIST_MBID)
    @Expose
    var artistMibd: String? = null,

    @SerializedName(ARTIST_URL)
    @Expose
    var artistUrl: String? = null,

    @SerializedName(ARTIST_IMAGE)
    @Expose
    var artistImage: List<ImageData>? = null
) {

    companion object {
        const val ARTIST_NAME = "name"
        const val ARTIST_LISTENERS = "listeners"
        const val ARTIST_MBID = "mbid"
        const val ARTIST_URL = "url"
        const val ARTIST_IMAGE = "image"
    }
}