package com.example.bostatask.homeScreen.model.user

data class User(
    val address: Address? = null,
    val company: Company? = null,
    val email: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val username: String? = null,
    val website: String? = null
)