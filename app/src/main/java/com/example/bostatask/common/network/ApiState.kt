package com.example.bostatask.common.network

/**
 * ApiState class that provide the screen with state of response (Loading, Success and Failure)
 */
sealed class ApiState {
    data class Success<T>(val data: T) : ApiState()
    data class Failure(val error: Throwable) : ApiState()
    data object Loading : ApiState()
}