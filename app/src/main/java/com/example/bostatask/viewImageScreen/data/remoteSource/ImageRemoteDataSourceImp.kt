package com.example.bostatask.viewImageScreen.data.remoteSource

import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.data.retrofit.ImageApi
import javax.inject.Inject

/**
 ** ImageRemoteDataSourceImp class implement ImageRemoteDataSource interface and provides
 *  implementation to it's method
 *
 * @param service an instance of ImageApi that responsible to get selected image from api with Get method
 */
class ImageRemoteDataSourceImp @Inject constructor(private val service: ImageApi) :
    ImageRemoteDataSource {
    override suspend fun getSelectedImage(albumId: Int, imageId: Int): PhotosItem {
        return service.getSelectedImage(albumId, imageId)[0]
    }
}