package com.example.bostatask.homeScreen.data.remotDataSource

import com.example.bostatask.homeScreen.data.retrofit.HomeApiService
import com.example.bostatask.homeScreen.model.user.User
import javax.inject.Inject

/**
 ** UserRemoteDataSourceImp class implement UserRemoteDataSource interface and provides
 *  implementation to it's method
 *
 * @param service an instance of HomeApiService that responsible to get user data from api with Get method
 */
class UserRemoteDataSourceImp @Inject constructor(private val service: HomeApiService) :
    UserRemoteDataSource {
    override suspend fun getUser(userId: Int): User {
        return service.getUsers(userId)
    }
}