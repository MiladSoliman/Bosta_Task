package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.model.user.User
import javax.inject.Inject

class UserRemoteDataSourceImp @Inject constructor(private val service : HomeApiService) : UserRemoteDataSource {
    override suspend fun getUser(userId:Int): User {
        return service.getUsers(userId)
    }
}