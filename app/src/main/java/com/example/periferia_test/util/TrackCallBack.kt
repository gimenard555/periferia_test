package com.example.periferia_test.util

import androidx.recyclerview.widget.DiffUtil
import com.example.periferia_test.network.serializableobjects.TrackData

class TrackCallBack : DiffUtil.ItemCallback<TrackData>() {
    override fun areItemsTheSame(oldItem: TrackData, newItem: TrackData): Boolean {
        return oldItem.trackName == newItem.trackName
    }

    override fun areContentsTheSame(oldItem: TrackData, newItem: TrackData): Boolean {
        return oldItem.trackUrl == newItem.trackUrl
    }
}