package com.example.bostatask.homeScreen.domin.repo

import com.example.bostatask.homeScreen.model.album.Albums

/**
 *** AlbumsRepo an interface, for passing data between the layers
 */
interface AlbumsRepo {
    suspend fun getAlbums(userId: Int): Albums
}