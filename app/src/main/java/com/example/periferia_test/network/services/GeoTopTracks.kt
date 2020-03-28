package com.example.periferia_test.network.services

import com.example.periferia_test.network.serializableobjects.TopTrackData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoTopTracks {

    @GET(URL)
    suspend fun getTopTracks(
        @Query("method") method: String = "geo.gettoptracks",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("country") country: String
    ): Response<TopTrackData>

    companion object {
        const val URL = "/2.0/"
        const val API_KEY = "829751643419a7128b7ada50de590067"
    }
}