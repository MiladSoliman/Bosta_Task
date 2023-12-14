package com.example.bostatask.homeScreen.data.retrofit


import com.example.bostatask.homeScreen.model.album.Albums
import com.example.bostatask.homeScreen.model.user.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * retrofit interface that has Get methods to call api
 */
interface HomeApiService {

    @GET("users/{userId}")
    suspend fun getUsers(@Path("userId") userId: Int): User

    @GET("albums")
    suspend fun getAlbums(@Query("userId") userId: Int): Albums
}