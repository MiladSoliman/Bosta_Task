package com.example.bostatask.detailsScreen.data.remotDataSource

import com.example.bostatask.detailsScreen.model.Photos

/**
 *** RemoteDataSource an interface, for passing data between the layers
 */
interface AlbumPhotosRemoteDataSource {
    suspend fun getAlbumPhotos(albumId: Int): Photos
}