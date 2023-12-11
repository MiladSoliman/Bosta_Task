package com.example.bostatask.detailsScreen.data.repo

import com.example.bostatask.detailsScreen.data.remotDataSource.AlbumPhotosRemoteDataSource
import com.example.bostatask.detailsScreen.domin.repo.AlbumPhotosRepo
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

class AlbumPhotosRepoImp @Inject constructor(private val remote: AlbumPhotosRemoteDataSource) : AlbumPhotosRepo{
    override suspend fun getAlbumPhotos(): Photos {
        return remote.getAlbumPhotos()
    }
}