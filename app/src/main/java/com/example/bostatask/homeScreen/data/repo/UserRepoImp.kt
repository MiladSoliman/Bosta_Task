package com.example.bostatask.homeScreen.data.repo

import com.example.bostatask.homeScreen.data.remotDataSource.UserRemoteDataSource
import com.example.bostatask.homeScreen.domin.repo.UsersRepo
import com.example.bostatask.homeScreen.model.User
import javax.inject.Inject

class UserRepoImp @Inject constructor(private val remote: UserRemoteDataSource) : UsersRepo {
    override suspend fun getUser(userId:Int): User {
        return remote.getUser(userId)
    }
}