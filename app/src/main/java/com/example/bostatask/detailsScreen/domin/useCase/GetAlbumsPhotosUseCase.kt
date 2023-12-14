package com.example.bostatask.detailsScreen.domin.useCase

import com.example.bostatask.detailsScreen.domin.repo.AlbumPhotosRepo
import com.example.bostatask.detailsScreen.model.Photos
import javax.inject.Inject

/**
 *** GetAlbumsPhotosUseCase Class that responsible for get specific album photos
 * @param repo to provide execute method with tha list of photos
 */
class GetAlbumsPhotosUseCase @Inject constructor(private val repo: AlbumPhotosRepo) {
    suspend fun execute(albumId: Int): Photos {
        return repo.getAlbumPhotos(albumId)
    }
}