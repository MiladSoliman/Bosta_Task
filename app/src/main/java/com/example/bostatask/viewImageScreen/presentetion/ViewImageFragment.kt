package com.example.bostatask.viewImageScreen.presentetion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.bostatask.R
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.databinding.FragmentViewImagBinding
import com.example.bostatask.detailsScreen.model.PhotosItem
import com.example.bostatask.viewImageScreen.ImageScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ViewImageFragment : Fragment() {
    private val imageViewModel : ImageScreenViewModel by viewModels()
  private  lateinit var binding:FragmentViewImagBinding
  private var albumId = 0
   private var imageId = 0
    lateinit var image: PhotosItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewImagBinding.inflate(inflater)
        albumId = requireArguments().getInt("albumId")
        imageId = requireArguments().getInt("imageId")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewModel.getSelectedImage(albumId,imageId)
        observeOnImageDataResult()

        binding.btnShare.setOnClickListener {
            Log.i("ImageScreen",image.url)
        }
    }


    private fun observeOnImageDataResult(){
        lifecycleScope.launch {
            imageViewModel.imageData.collect{
                when(it){
                    is ApiState.Loading -> {
                        binding.imageShimmer.visibility = View.VISIBLE
                        binding.btnShare.visibility = View.GONE
                    }
                    is ApiState.Success<*> -> {
                        binding.imageShimmer.visibility = View.GONE
                        binding.btnShare.visibility = View.VISIBLE
                       image = it.data as PhotosItem
                        setSelectedImage(image)
                    }
                    else -> {
                        Log.i("imageScreen","Error")
                        showErrorSplash()
                    }
                }
            }
        }
    }

    private fun showErrorSplash() {
        binding.imageShimmer.visibility = View.VISIBLE
        binding.imageScreenErrorSplash.visibility = View.VISIBLE
        binding.btnShare.visibility =View.GONE
    }

    private fun setSelectedImage(image: PhotosItem) {
        Glide.with(binding.root).load(image.url)
            .placeholder(R.drawable.placholder)
            .into(binding.imageView)
    }


}