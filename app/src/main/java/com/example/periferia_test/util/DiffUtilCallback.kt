package com.example.periferia_test.util

import androidx.recyclerview.widget.DiffUtil
import com.example.periferia_test.network.serializableobjects.ArtistData

class DiffUtilCallback : DiffUtil.ItemCallback<ArtistData>() {
    override fun areItemsTheSame(oldItem: ArtistData, newItem: ArtistData): Boolean {
        return oldItem.artistName == newItem.artistName
    }

    override fun areContentsTheSame(oldItem: ArtistData, newItem: ArtistData): Boolean {
        return oldItem.artistUrl == newItem.artistUrl
    }
}