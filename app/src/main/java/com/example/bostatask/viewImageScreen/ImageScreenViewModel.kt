package com.example.bostatask.viewImageScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.viewImageScreen.domin.useCase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ImageScreenViewModel @Inject constructor(private val getImageUseCase: GetImageUseCase) :ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    private val _imageData: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val imageData = _imageData


     fun getSelectedImage(albumId:Int,imageId:Int) {
         viewModelScope.launch {
             try {
                 Log.i("ImageScreenViewModel", getImageUseCase.execute(albumId, imageId).title)
                 _imageData.value = ApiState.Success(getImageUseCase.execute(albumId,imageId))
             }catch (e:Exception){
                 _imageData.value = ApiState.Failure(e)
             }
         }
     }
}