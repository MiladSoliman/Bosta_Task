package com.example.bostatask.detailsScreen.data.remotDataSource

import com.example.bostatask.detailsScreen.data.retrofit.DetailsScreenApi
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

class AlbumPhotosRemoteDataSourceImp @Inject constructor(private val service: DetailsScreenApi) : AlbumPhotosRemoteDataSource {
    override suspend fun getAlbumPhotos(): Photos {
        return service.getPhotosOfAlbum()
    }
}