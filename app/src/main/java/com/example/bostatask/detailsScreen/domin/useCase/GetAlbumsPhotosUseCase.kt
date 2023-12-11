package com.example.bostatask.detailsScreen.domin.useCase

import com.example.bostatask.detailsScreen.domin.repo.AlbumPhotosRepo
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

class GetAlbumsPhotosUseCase @Inject constructor(private val repo : AlbumPhotosRepo) {


    suspend fun execute(albumId:Int) : Photos {
        return repo.getAlbumPhotos(albumId)
    }
}