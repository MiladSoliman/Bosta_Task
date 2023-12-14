package com.example.bostatask.viewImageScreen.data.retrofit

import com.example.bostatask.detailsScreen.model.Photos
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit interface that has Get method to call api
 */
interface ImageApi {

    @GET("photos")
    suspend fun getSelectedImage(@Query("albumId") albumId: Int, @Query("id") id: Int): Photos
}