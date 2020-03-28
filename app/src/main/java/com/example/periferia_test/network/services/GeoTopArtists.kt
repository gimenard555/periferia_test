package com.example.periferia_test.network.services

import com.example.periferia_test.network.serializableobjects.TopArtistData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoTopArtists {

    @GET(URL)
    suspend fun getTopArtists(
        @Query("method") method: String = "geo.gettopartists",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("country") country: String
    ): Response<TopArtistData>

    companion object {
        const val URL = "/2.0/"
        const val API_KEY = "829751643419a7128b7ada50de590067"
    }
}