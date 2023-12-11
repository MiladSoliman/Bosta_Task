package com.example.bostatask.homeScreen.domin.useCase

import com.example.bostatask.homeScreen.domin.repo.UsersRepo
import com.example.bostatask.homeScreen.model.User
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repo : UsersRepo){

    suspend fun execute(userId:Int) : User {
        return repo.getUser(userId)
    }

}