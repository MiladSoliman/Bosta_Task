package com.example.bostatask.detailsScreen.domin.repo

import com.example.bostatask.detailsScreen.model.Photos

interface AlbumPhotosRepo {

    suspend fun getAlbumPhotos():Photos
}