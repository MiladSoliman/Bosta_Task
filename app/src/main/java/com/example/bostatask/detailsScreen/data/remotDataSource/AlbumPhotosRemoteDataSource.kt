package com.example.bostatask.detailsScreen.data.remotDataSource

import com.example.bostatask.detailsScreen.model.Photos

interface AlbumPhotosRemoteDataSource {

    suspend fun getAlbumPhotos() : Photos
}