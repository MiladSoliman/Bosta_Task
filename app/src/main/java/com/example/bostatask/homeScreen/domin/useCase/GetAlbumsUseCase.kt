package com.example.bostatask.homeScreen.domin.useCase

import com.example.bostatask.homeScreen.domin.repo.AlbumsRepo
import com.example.bostatask.homeScreen.model.album.Albums
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val repo: AlbumsRepo) {
    suspend fun execute(userId:Int) : Albums {
        return repo.getAlbums(userId)
    }
}