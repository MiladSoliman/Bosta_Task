package com.example.bostatask.homeScreen.model.user

import com.example.bostatask.homeScreen.model.user.Address
import com.example.bostatask.homeScreen.model.user.Company

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)