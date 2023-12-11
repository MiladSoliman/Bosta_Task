package com.example.bostatask.homeScreen.presention

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bostatask.databinding.AlbumItemBinding
import com.example.bostatask.homeScreen.model.album.AlbumsItem

class AlbumsAdapter(private var albumsList : List<AlbumsItem> , val onAlbumClick: OnAlbumClick) : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlbumsViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return albumsList.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val album = albumsList[position]
          holder.binding.txtAlbumName.text = album.title
        holder.binding.root.setOnClickListener {
            onAlbumClick.showAlbumDetails(album)
        }
    }

    fun updateList(albumsList: List<AlbumsItem>){
        this.albumsList = albumsList
        notifyDataSetChanged()
    }

    inner class AlbumsViewHolder(val binding: AlbumItemBinding) :
        RecyclerView.ViewHolder(binding.root)


}