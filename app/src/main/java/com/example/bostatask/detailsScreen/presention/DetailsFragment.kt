package com.example.bostatask.detailsScreen.presention

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LOGGER
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bostatask.R
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.databinding.FragmentDetailsBinding
import com.example.bostatask.detailsScreen.DetailsScreenViewModel
import com.example.bostatask.detailsScreen.model.Photos
import com.example.bostatask.homeScreen.presention.AlbumsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    private val detailsViewModel : DetailsScreenViewModel by viewModels()
    private var albumId = 0
    private lateinit var albumName :String
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        albumId = requireArguments().getInt("albumId")
        albumName = requireArguments().getString("albumName").toString()
        photosAdapter = PhotosAdapter(emptyList())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       detailsViewModel.getPhotos(albumId)
        binding.textAlbumName.text = albumName
        binding.photosRv.adapter = photosAdapter
        lifecycleScope.launch {
            detailsViewModel.photosList.collect{ result->
                when(result){
                    is ApiState.Loading -> {
                        Log.i("DetailsScreen","Loading")
                    }
                    is ApiState.Success<*> -> {
                        Log.i("DetailsScreen","Success")
                        val photosList = result.data as Photos
                       photosAdapter.updateList(photosList)
                    }
                    else -> {
                        Log.i("DetailsScreen","Error....")
                    }
                }
            }
        }
    }

}