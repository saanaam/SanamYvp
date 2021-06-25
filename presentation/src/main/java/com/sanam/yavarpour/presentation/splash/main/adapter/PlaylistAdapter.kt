package com.sanam.yavarpour.presentation.splash.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanam.yavarpour.presentation.R
import com.sanam.yavarpour.presentation.splash.main.model.MusicItemModel
import kotlinx.android.synthetic.main.holder_song.view.*
import kotlin.properties.Delegates


internal class PlaylistAdapter(val mListener: OnPlaylistAdapterListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var songs: List<MusicItemModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    /*
     * This method is called right when adapter is created &
     * is used to initialize ViewHolders
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewSongItemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.holder_song, parent, false)
        return SongViewHolder(viewSongItemHolder)
    }

    /* It is called for each ViewHolder to bind it to the adapter &
     * This is where we pass data to ViewHolder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SongViewHolder).onBind(getItem(position))
    }

    fun getItem(position: Int): MusicItemModel {
        return songs[position]
    }

    /*
     * This method returns the size of collection that contains the items we want to display
     * */
    override fun getItemCount(): Int {
        return songs.size
    }


    fun getItems() = songs

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(song: MusicItemModel) {
            itemView.music_item_name_text_view.text = "music Number : $song.id "
            itemView.setOnClickListener {
                mListener.onMusicItemClick(song, adapterPosition)
            }

        }
    }

}
