package com.example.bostatask.common.util

import kotlin.random.Random


class Constants {
    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        /**
         * function to get random user id
         */
        fun getRandomUserId(): Int {
            return Random.nextInt(1, 11)
        }
    }
}