package com.example.bostatask.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.homeScreen.domin.useCase.GetAlbumsUseCase
import com.example.bostatask.homeScreen.domin.useCase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
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
   /* init {
        getUser()
    }*/

    fun getUser(userId:Int){
        viewModelScope.launch(coroutineExceptionHandler) {
           Log.i("HomeViewModelUser",getUsersUseCase.execute(userId).toString() )
            Log.i("HomeViewModelAlbums", getAlbumsUseCase.execute(userId).size.toString())
        }
    }
}