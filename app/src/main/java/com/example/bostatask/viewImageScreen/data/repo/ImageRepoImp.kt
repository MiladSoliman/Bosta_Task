package com.example.bostatask.viewImageScreen.data.repo

import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.data.remoteSource.ImageRemoteDataSource
import com.example.bostatask.viewImageScreen.domin.repo.ImageRepo
import javax.inject.Inject

class ImageRepoImp @Inject constructor(private val remote: ImageRemoteDataSource) : ImageRepo {

  override  suspend fun getSelectedImage(albumId:Int,imageId:Int) : PhotosItem {
        return remote.getSelectedImage(albumId,imageId)
    }
}