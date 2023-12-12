package com.example.bostatask.detailsScreen.presention

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.bostatask.detailsScreen.model.PhotosItem
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
    private lateinit var photosList : List<PhotosItem>
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
        binding.textAlbumName.text = albumName
        binding.photosRv.adapter = photosAdapter
        observeOnPhotosList()
        detailsViewModel.getPhotos(albumId)
        searchInImages()
    }


    private fun observeOnPhotosList(){
        lifecycleScope.launch {
            detailsViewModel.photosList.collect{ result->
                when(result){
                    is ApiState.Loading -> {
                        Log.i("DetailsScreen","Loading")
                    }
                    is ApiState.Success<*> -> {
                        Log.i("DetailsScreen","Success")
                        binding.imagesSearch.visibility = View.VISIBLE
                        binding.photosShimmer.visibility = View.GONE
                        binding.photosRv.visibility = View.VISIBLE
                        photosList = result.data as Photos
                        photosAdapter.updateList(photosList)
                    }
                    else -> {
                        Log.i("DetailsScreen","Error....")
                        showErrorSplash()
                    }
                }
            }
        }
    }

    private fun showErrorSplash() {
        binding.photosShimmer.visibility = View.GONE
        binding.errorSplash.visibility = View.VISIBLE
        binding.textAlbumName.visibility = View.GONE
        binding.imagesSearch.visibility = View.GONE
    }

    private fun searchInImages(){
        binding.imagesSearch.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    filterImages(s.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun filterImages(name:String){
        val searchedImages = mutableListOf<PhotosItem>()
        for (photo in photosList) {
            if (photo.title.lowercase().contains(name.lowercase())) {
                searchedImages.add(photo)
                Log.i("HomeScreen","in search")
            }

        }
        photosAdapter.updateList(searchedImages)
        if (searchedImages.isEmpty()){
            binding.noImagesSplash.visibility = View.VISIBLE
        }else{
            binding.noImagesSplash.visibility = View.GONE
        }
    }



}