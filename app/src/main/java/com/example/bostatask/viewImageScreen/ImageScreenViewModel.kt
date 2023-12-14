package com.example.bostatask.viewImageScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.viewImageScreen.domin.useCase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ImageScreenViewModel class for selected image
 *
 * @param getImageUseCase The use case to get selected image from remote data source
 *
 */
@HiltViewModel
class ImageScreenViewModel @Inject constructor(private val getImageUseCase: GetImageUseCase) :
    ViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        _imageData.value = ApiState.Failure(throwable)
    }

    private val _imageData: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val imageData = _imageData


    fun getSelectedImage(albumId: Int, imageId: Int) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                _imageData.value = ApiState.Success(getImageUseCase.execute(albumId, imageId))
            } catch (e: Exception) {
                _imageData.value = ApiState.Failure(e)
            }
        }
    }
}