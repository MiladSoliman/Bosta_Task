package com.example.bostatask.homeScreen.domin.useCase

import com.example.bostatask.homeScreen.domin.repo.AlbumsRepo
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

/**
 *** GetAlbumsUseCase Class that responsible for get list of albums per user
 * @param repo to provide execute method with tha list of user albums
 */
class GetAlbumsUseCase @Inject constructor(private val repo: AlbumsRepo) {
    suspend fun execute(userId: Int): Albums {
        return repo.getAlbums(userId)
    }
}