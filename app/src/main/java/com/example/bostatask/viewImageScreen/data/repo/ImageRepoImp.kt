package com.example.bostatask.viewImageScreen.data.repo

import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.data.remoteSource.ImageRemoteDataSource
import com.example.bostatask.viewImageScreen.domin.repo.ImageRepo
import javax.inject.Inject

/**
 ** ImageRepoImp implement ImageRepo interface, provide implementation for methods to pass return
 * data to use case classes
 *
 **@param remote instance of ImageRemoteDataSource interface that responsible for getting selected image
 * from remote data source
 */
class ImageRepoImp @Inject constructor(private val remote: ImageRemoteDataSource) : ImageRepo {

    override suspend fun getSelectedImage(albumId: Int, imageId: Int): PhotosItem {
        return remote.getSelectedImage(albumId, imageId)
    }
}