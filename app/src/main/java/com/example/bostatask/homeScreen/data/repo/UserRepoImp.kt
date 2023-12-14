package com.example.bostatask.homeScreen.data.repo

import com.example.bostatask.homeScreen.data.remotDataSource.UserRemoteDataSource
import com.example.bostatask.homeScreen.domin.repo.UsersRepo
import com.example.bostatask.homeScreen.model.user.User
import javax.inject.Inject

/**
 ** UserRepoImp implement UserRepo interface, provide implementation for methods to pass return
 * data to use case classes
 *
 **@param remote instance of UserRemoteDataSource interface that responsible for getting random user data
 * from remote data source
 */
class UserRepoImp @Inject constructor(private val remote: UserRemoteDataSource) : UsersRepo {
    override suspend fun getUser(userId: Int): User {
        return remote.getUser(userId)
    }
}