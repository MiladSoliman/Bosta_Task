package com.example.bostatask.detailsScreen.data.repo

import com.example.bostatask.detailsScreen.data.remotDataSource.AlbumPhotosRemoteDataSource
import com.example.bostatask.detailsScreen.domin.repo.AlbumPhotosRepo
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

/**
 ** AlbumPhotosRepoImp implement AlbumPhotosRepo interface,
 * provide implementation for methods to pass return data to use case classes
 *
 **@param remote instance of AlbumPhotosRemoteDataSource interface that responsible for getting list of specific album photos
 * from remote data source
 */
class AlbumPhotosRepoImp @Inject constructor(private val remote: AlbumPhotosRemoteDataSource) :
    AlbumPhotosRepo {
    override suspend fun getAlbumPhotos(albumId: Int): Photos {
        return remote.getAlbumPhotos(albumId)
    }
}