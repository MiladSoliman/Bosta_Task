package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.model.album.Albums

/**
 *** RemoteDataSource an interface, for passing data between the layers
 */
interface AlbumsRemoteDataSource {
    suspend fun getAlbums(userId: Int): Albums
}