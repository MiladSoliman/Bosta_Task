package com.example.bostatask.viewImageScreen.data.remoteSource

import com.example.bostatask.detailsScreen.model.PhotosItem

interface ImageRemoteDataSource {

    suspend fun getSelectedImage(albumId:Int,imageId:Int) : PhotosItem
}