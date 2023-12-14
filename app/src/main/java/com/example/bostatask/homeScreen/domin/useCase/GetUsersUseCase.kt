package com.example.bostatask.homeScreen.domin.useCase

import com.example.bostatask.homeScreen.domin.repo.UsersRepo
import com.example.bostatask.homeScreen.model.user.User
import javax.inject.Inject

/**
 *** GetUsersUseCase Class that responsible for get random user when the app starting
 * @param repo to provide execute method with tha user data
 */
class GetUsersUseCase @Inject constructor(private val repo: UsersRepo) {

    suspend fun execute(userId: Int): User {
        return repo.getUser(userId)
    }

}