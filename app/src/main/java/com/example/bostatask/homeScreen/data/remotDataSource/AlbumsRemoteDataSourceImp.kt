package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

class AlbumsRemoteDataSourceImp @Inject constructor(private val service: HomeApiService) : AlbumsRemoteDataSource {
    override suspend fun getAlbums(): Albums {
        return service.getAlbums()
    }
}