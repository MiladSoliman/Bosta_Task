package com.example.bostatask.homeScreen.data.retrofit


import com.example.bostatask.homeScreen.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeApiService {

    @GET("users/{userId}")
    suspend fun getUsers(@Path("userId") userId:Int) : User
}