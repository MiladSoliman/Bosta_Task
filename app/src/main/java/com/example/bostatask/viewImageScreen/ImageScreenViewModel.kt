package com.example.bostatask.viewImageScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.viewImageScreen.domin.useCase.GetImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ImageScreenViewModel @Inject constructor(private val getImageUseCase: GetImageUseCase) :ViewModel() {
     fun getSelectedImage(albumId:Int,imageId:Int) {
         viewModelScope.launch {
             Log.i("ImageScreenViewModel", getImageUseCase.execute(albumId, imageId).title)
         }
     }
}