package com.example.periferia_test.network.serializableobjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TrackData (
    @SerializedName(TRACK_NAME)
    @Expose
    var trackName: String? = null,

    @SerializedName(TRACK_DURATION)
    @Expose
    var trackDuration: String? = null,

    @SerializedName(TRACK_LISTENERS)
    @Expose
    var trackListeners: String? = null,

    @SerializedName(TRACK_MBID)
    @Expose
    var trackMibd: String? = null,

    @SerializedName(TRACK_URL)
    @Expose
    var trackUrl: String? = null,

    @SerializedName(TRACK_ARTIST)
    @Expose
    var trackArtist: ArtistData? = null,

    @SerializedName(TRACK_IMAGE)
    @Expose
    var trackImage: ImageData? = null
) {


    companion object {
        const val TRACK_NAME = "name"
        const val TRACK_DURATION = "duration"
        const val TRACK_LISTENERS = "listeners"
        const val TRACK_MBID = "mbid"
        const val TRACK_URL = "url"
        const val TRACK_ARTIST = "artist"
        const val TRACK_IMAGE = "image"
    }
}