package com.example.bostatask.homeScreen.data.repo

import com.example.bostatask.homeScreen.data.remotDataSource.AlbumsRemoteDataSource
import com.example.bostatask.homeScreen.domin.repo.AlbumsRepo
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

class AlbumsRepoImp @Inject constructor(private val remote: AlbumsRemoteDataSource) : AlbumsRepo {
    override suspend fun getAlbums(): Albums {
        return remote.getAlbums()
    }
}