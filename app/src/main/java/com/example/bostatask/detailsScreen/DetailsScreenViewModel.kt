package com.example.bostatask.detailsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.detailsScreen.domin.useCase.GetAlbumsPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getAlbumsPhotosUseCase: GetAlbumsPhotosUseCase
) :ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private var _photosList : MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val photosList = _photosList

    fun getPhotos(albumId:Int){
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                Log.i("DetailsViewModel",getAlbumsPhotosUseCase.execute(albumId)[0].url + albumId)
                _photosList.value = ApiState.Success(getAlbumsPhotosUseCase.execute(albumId))
            }catch (e:Exception){
                _photosList.value = ApiState.Failure(e)
            }
        }
    }
}