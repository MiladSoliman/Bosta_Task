package com.example.bostatask.viewImageScreen.data.remoteSource

import com.example.bostatask.detailsScreen.model.PhotosItem

/**
 *** RemoteDataSource an interface, for passing data between the layers
 */
interface ImageRemoteDataSource {

    suspend fun getSelectedImage(albumId: Int, imageId: Int): PhotosItem
}