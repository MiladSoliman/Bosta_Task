package com.example.bostatask.homeScreen.domin.repo

import com.example.bostatask.homeScreen.model.User

interface UsersRepo {
    suspend fun getUser(userId:Int):User
}