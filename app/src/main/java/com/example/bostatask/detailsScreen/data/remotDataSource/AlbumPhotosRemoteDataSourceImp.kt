package com.example.bostatask.detailsScreen.data.remotDataSource

import com.example.bostatask.detailsScreen.data.retrofit.DetailsScreenApi
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

/**
 ** AlbumPhotosRemoteDataSourceImp class implement AlbumPhotosRemoteDataSource interface and provides
 *  implementation to it's method
 *
 * @param service an instance of DetailsScreenApi that responsible to get data from api with Get method
 */
class AlbumPhotosRemoteDataSourceImp @Inject constructor(private val service: DetailsScreenApi) :
    AlbumPhotosRemoteDataSource {
    override suspend fun getAlbumPhotos(albumId: Int): Photos {
        return service.getPhotosOfAlbum(albumId)
    }
}