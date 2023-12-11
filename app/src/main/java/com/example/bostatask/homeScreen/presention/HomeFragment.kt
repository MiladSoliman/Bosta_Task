package com.example.bostatask.homeScreen.presention

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bostatask.R
import com.example.bostatask.databinding.FragmentHomeBinding
import com.example.bostatask.detailsScreen.DetailsScreenViewModel
import com.example.bostatask.homeScreen.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private val homeViewModel : HomeViewModel by viewModels()
    private val detailsViewModel : DetailsScreenViewModel by viewModels()
    private lateinit var albumsAdapter: AlbumsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater)
        albumsAdapter = AlbumsAdapter(listOf())
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getUser(1)
        homeViewModel.getAlbums(1)
        detailsViewModel.getPhotos(1)

        homeBinding.albumsRV.layoutManager = LinearLayoutManager(requireContext())
        homeBinding.albumsRV.adapter = albumsAdapter

       lifecycleScope.launch {
           homeViewModel.userDetails.collect {
             homeBinding.txtuserName.text = it.name
             homeBinding.txtUserAddress.text =  it.address?.street + ","+it.address?.suite +","+ it.address?.city+","
             homeBinding.txtUserPhone.text = it.address?.zipcode
           }
       }
       lifecycleScope.launch {
           homeViewModel.albumsData.collect{
               albumsAdapter.updateList(it)
           }
       }
    }

}