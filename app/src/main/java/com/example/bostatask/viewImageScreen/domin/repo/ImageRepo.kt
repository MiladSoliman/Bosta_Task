package com.example.bostatask.viewImageScreen.domin.repo

import com.example.bostatask.detailsScreen.model.PhotosItem

interface ImageRepo {
    suspend fun getSelectedImage(albumId:Int,imageId:Int) : PhotosItem
}