package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.model.user.User

/**
 *** RemoteDataSource an interface, for passing data between the layers
 */
interface UserRemoteDataSource {
    suspend fun getUser(userId: Int): User
}