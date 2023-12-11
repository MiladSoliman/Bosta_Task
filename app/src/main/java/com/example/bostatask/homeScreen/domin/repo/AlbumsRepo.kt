package com.example.bostatask.homeScreen.domin.repo

import com.example.bostatask.homeScreen.model.album.Albums

interface AlbumsRepo {
    suspend fun getAlbums(userId:Int) : Albums
}