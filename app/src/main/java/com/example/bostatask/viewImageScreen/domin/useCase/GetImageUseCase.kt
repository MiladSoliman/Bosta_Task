package com.example.bostatask.viewImageScreen.domin.useCase

import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.domin.repo.ImageRepo
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val repo: ImageRepo)  {

    suspend fun execute(albumID:Int,imageId:Int) : PhotosItem {
        return repo.getSelectedImage(albumID,imageId)
    }
}