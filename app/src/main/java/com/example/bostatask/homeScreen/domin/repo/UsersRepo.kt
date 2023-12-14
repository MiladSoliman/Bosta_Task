package com.example.bostatask.homeScreen.domin.repo

import com.example.bostatask.homeScreen.model.user.User

/**
 *** UsersRepo an interface, for passing data between the layers
 */
interface UsersRepo {
    suspend fun getUser(userId: Int): User
}