package com.example.bostatask.viewImageScreen.domin.repo

import com.example.bostatask.detailsScreen.model.PhotosItem

/**
 *** ImageRepo an interface, for passing data between the layers
 */
interface ImageRepo {
    suspend fun getSelectedImage(albumId: Int, imageId: Int): PhotosItem
}