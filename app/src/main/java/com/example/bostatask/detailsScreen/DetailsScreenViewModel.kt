package com.example.bostatask.detailsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.detailsScreen.domin.useCase.GetAlbumsPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getAlbumsPhotosUseCase: GetAlbumsPhotosUseCase
) :ViewModel() {


    fun getPhotos(albumId:Int){
        viewModelScope.launch {
            Log.i("HomeViewModel",getAlbumsPhotosUseCase.execute(albumId).size.toString())
        }
    }
}