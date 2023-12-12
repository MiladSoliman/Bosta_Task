package com.example.bostatask.common.util

import kotlin.random.Random


class Constants {
    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"


        fun getRandomUserId():Int{
            return Random.nextInt(1, 11)
        }
    }
}