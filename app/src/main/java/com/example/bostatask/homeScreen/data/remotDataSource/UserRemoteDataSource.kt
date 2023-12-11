package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.model.user.User

interface UserRemoteDataSource {
    suspend fun getUser(userId:Int): User
}