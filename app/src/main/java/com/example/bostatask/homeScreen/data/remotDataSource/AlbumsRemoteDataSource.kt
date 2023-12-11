package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.model.album.Albums

interface AlbumsRemoteDataSource {
    suspend fun getAlbums(userId:Int) : Albums
}