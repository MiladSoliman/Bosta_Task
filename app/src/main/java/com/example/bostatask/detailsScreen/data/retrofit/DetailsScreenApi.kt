package com.example.bostatask.detailsScreen.data.retrofit

import com.example.bostatask.detailsScreen.model.Photos
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofit interface that has Get method to call api
 */
interface DetailsScreenApi {

    @GET("photos")
    suspend fun getPhotosOfAlbum(@Query("albumId") albumId: Int): Photos
}