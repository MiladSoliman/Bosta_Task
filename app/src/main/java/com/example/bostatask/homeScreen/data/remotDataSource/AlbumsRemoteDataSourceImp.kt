package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

/**
 ** AlbumsRemoteDataSourceImp class implement AlbumsRemoteDataSource interface and provides
 *  implementation to it's method
 *
 * @param service an instance of HomeApiService that responsible to get list of albums from api with Get method
 */
class AlbumsRemoteDataSourceImp @Inject constructor(private val service: HomeApiService) :
    AlbumsRemoteDataSource {
    override suspend fun getAlbums(userId: Int): Albums {
        return service.getAlbums(userId)
    }
}