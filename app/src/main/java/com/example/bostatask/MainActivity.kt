package com.example.bostatask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bostatask.detailsScreen.DetailsScreenViewModel
import com.example.bostatask.homeScreen.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel : HomeViewModel by viewModels()
    private val detailsViewModel : DetailsScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel.getUser(1)
        detailsViewModel.getPhotos()
    }
}