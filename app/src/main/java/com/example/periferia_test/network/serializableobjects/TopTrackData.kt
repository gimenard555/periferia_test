package com.example.periferia_test.network.serializableobjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TopTrackData(
    @SerializedName(TOP_TRACK_NAME)
    @Expose
    val topTracks: List<TrackData>?
) {

    companion object {
        const val TOP_TRACK_NAME = "track"
    }
}