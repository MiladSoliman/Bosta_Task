package com.example.bostatask.homeScreen.data.remotDataSource

import android.util.Log
import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.model.User
import javax.inject.Inject

class UserRemoteDataSourceImp @Inject constructor(private val service : HomeApiService) : UserRemoteDataSource {
    override suspend fun getUser(userId:Int): User {
        return service.getUsers(userId)
    }
}