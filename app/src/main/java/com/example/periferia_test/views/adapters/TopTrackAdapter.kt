package com.example.periferia_test.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.periferia_test.R
import com.example.periferia_test.network.serializableobjects.TrackData
import com.example.periferia_test.util.TrackCallBack
import kotlinx.android.synthetic.main.item_artist_view_layout.view.*

class TopTrackAdapter : PagedListAdapter<TrackData, TopTrackAdapter.MyViewHolder>(TrackCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artist_view_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let { holder.bindPost(it) }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistImage = itemView.artist_image
        val artistNameText = itemView.artist_name
        val artistUrlText = itemView.artist_url

        fun bindPost(artistData: TrackData) {
            with(artistData) {
                /*Glide.with(itemView.context)
                    .load(artistImage)
                    .centerCrop() TODO SE CARGA UNA DE LAS IMAGENES QUE LLEGAN EN EL RESPONSE
                    .into(artistImage)*/
                /*artistNameText.text = artistName
                artistUrlText.text = artistUrl*/
            }
        }
    }

}