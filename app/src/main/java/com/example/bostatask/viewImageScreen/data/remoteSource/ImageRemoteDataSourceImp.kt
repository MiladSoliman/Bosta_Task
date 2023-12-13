package com.example.bostatask.viewImageScreen.data.remoteSource

import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.data.retrofit.ImageApi
import javax.inject.Inject

class ImageRemoteDataSourceImp @Inject constructor(private val service:ImageApi) : ImageRemoteDataSource {
    override suspend fun getSelectedImage(albumId: Int, imageId: Int) : PhotosItem{
        return service.getSelectedImage(albumId,imageId)[0]
    }
}