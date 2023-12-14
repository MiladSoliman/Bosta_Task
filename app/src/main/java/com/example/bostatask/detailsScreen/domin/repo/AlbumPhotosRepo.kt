package com.example.bostatask.detailsScreen.domin.repo

import com.example.bostatask.detailsScreen.model.Photos

/**
 *** AlbumPhotosRepo an interface, for passing data between the layers
 */
interface AlbumPhotosRepo {

    suspend fun getAlbumPhotos(albumId: Int): Photos
}