package com.example.bostatask.detailsScreen.presention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentDetailsBinding
import com.example.bostatask.detailsScreen.DetailsScreenViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    private val detailsViewModel : DetailsScreenViewModel by viewModels()
    private var albumId = 0
    lateinit var albumName :String

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       detailsViewModel.getPhotos(albumId)
        binding.textAlbumName.text = albumName
    }

}