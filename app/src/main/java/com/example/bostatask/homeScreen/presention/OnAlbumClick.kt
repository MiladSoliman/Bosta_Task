package com.example.bostatask.homeScreen.presention

import com.example.bostatask.homeScreen.model.album.AlbumsItem

interface OnAlbumClick {
    fun showAlbumDetails(album:AlbumsItem)
}