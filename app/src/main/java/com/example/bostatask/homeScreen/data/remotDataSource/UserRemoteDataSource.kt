package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.model.User

interface UserRemoteDataSource {
    suspend fun getUser(userId:Int):User
}