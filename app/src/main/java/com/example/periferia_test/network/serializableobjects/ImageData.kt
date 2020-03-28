package com.example.periferia_test.network.serializableobjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ImageData(
    @SerializedName(IMAGE_URL)
    @Expose
    var imageUrl: String? = null,

    @SerializedName(IMAGE_SIZE)
    @Expose
    var imageSize: String? = null
) {


    companion object {
        const val IMAGE_URL = "#text"
        const val IMAGE_SIZE = "size"
    }
}