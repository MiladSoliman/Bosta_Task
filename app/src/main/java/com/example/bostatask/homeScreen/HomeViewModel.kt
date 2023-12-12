package com.example.bostatask.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.homeScreen.domin.useCase.GetAlbumsUseCase
import com.example.bostatask.homeScreen.domin.useCase.GetUsersUseCase
import com.example.bostatask.homeScreen.model.album.Albums
import com.example.bostatask.homeScreen.model.album.AlbumsItem
import com.example.bostatask.homeScreen.model.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase)
    : ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private val _userDetails: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val userDetails = _userDetails

    private val _albumsData : MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
     val albumsData = _albumsData

    fun getUser(userId:Int){
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                _userDetails.value = ApiState.Success(getUsersUseCase.execute(userId))
                Log.i("HomeViewModelUser",getUsersUseCase.execute(userId).phone.toString() )
            }catch (e:Exception){
                _userDetails.value = ApiState.Failure(e)
            }

        }
    }

    fun getAlbums(userId: Int){
        viewModelScope.launch(coroutineExceptionHandler){
            try {
                _albumsData.value = ApiState.Success(getAlbumsUseCase.execute(userId))
                Log.i("HomeViewModelAlbums", getAlbumsUseCase.execute(userId).size.toString())
            }catch (e:Exception){
                _albumsData.value = ApiState.Failure(e)
            }

        }
    }
}