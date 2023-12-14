package com.example.bostatask.homeScreen.data.repo

import com.example.bostatask.homeScreen.data.remotDataSource.AlbumsRemoteDataSource
import com.example.bostatask.homeScreen.domin.repo.AlbumsRepo
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

/**
 ** AlbumsRepoImp implement AlbumsRepo interface, provide implementation for methods to pass return
 * data to use case classes
 *
 **@param remote instance of AlbumsRemoteDataSource interface that responsible for getting list of albums
 * from remote data source
 */
class AlbumsRepoImp @Inject constructor(private val remote: AlbumsRemoteDataSource) : AlbumsRepo {
    override suspend fun getAlbums(userId: Int): Albums {
        return remote.getAlbums(userId)
    }
}