package com.example.bostatask.homeScreen.presention

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bostatask.common.network.ApiState
import com.example.bostatask.common.util.Constants
import com.example.bostatask.databinding.FragmentHomeBinding
import com.example.bostatask.homeScreen.HomeViewModel
import com.example.bostatask.homeScreen.model.album.Albums
import com.example.bostatask.homeScreen.model.album.AlbumsItem
import com.example.bostatask.homeScreen.model.user.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 *** Home Fragment that responsible for observing on user data and his albums list
 **  Display the user data and his album in recycler view when the app is started
 *** @implement OnAlbumClick interface to get selected album from albums adapter and navigate to details screen
 */
@AndroidEntryPoint
class HomeFragment : Fragment(), OnAlbumClick {
    private lateinit var homeBinding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var albumsAdapter: AlbumsAdapter
    private var userId = Constants.getRandomUserId()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater)
        albumsAdapter = AlbumsAdapter(listOf(), this)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getUser(userId)
        homeViewModel.getAlbums(userId)
        homeBinding.albumsRV.layoutManager = LinearLayoutManager(requireContext())
        homeBinding.albumsRV.adapter = albumsAdapter
        observeOnUserResult()
        observeOnAlbumsResult()
    }

    /**
     * navigate to album details screen
     */
    override fun showAlbumDetails(album: AlbumsItem) {
        val action = HomeFragmentDirections.fromHomeToDetails(album.id, album.title)
        findNavController().navigate(action)
    }


    /**
     * observe on user data and display it when the call is successful
     */
    private fun observeOnUserResult() {
        lifecycleScope.launch {
            homeViewModel.userDetails.collect {
                when (it) {
                    is ApiState.Loading -> {
                        Log.i("HomeScreen", "Loading")
                    }

                    is ApiState.Success<*> -> {
                        hideUserShimmerAndShowUserData()
                        val user = it.data as User
                        homeBinding.txtuserName.text = user.name
                        homeBinding.txtUserAddress.text =
                            user.address?.street + "," + user.address?.suite + "," + user.address?.city + ","
                        homeBinding.txtUserPhone.text = user.address?.zipcode
                    }

                    else -> {
                        Log.i("HomeScreen", "Error")
                        showErrorSplash()
                    }
                }
            }
        }
    }

    /**
     * observe on user albums and display it when the call is successful
     */
    private fun observeOnAlbumsResult() {
        lifecycleScope.launch {
            homeViewModel.albumsData.collect {
                when (it) {
                    is ApiState.Loading -> {
                        Log.i("HomeScreen", "LoadingAlbums")
                    }

                    is ApiState.Success<*> -> {
                        hideShimmerAndAlbumsRecycler()
                        val albumsList = it.data as Albums
                        albumsAdapter.updateList(albumsList)
                    }

                    is ApiState.Failure -> {
                        Log.i("HomeScreen", "ErrorAlbums")
                        showErrorSplash()
                    }

                }

            }
        }
    }

    /**
     * hide shimmer loading effect when data is ready to show
     */
    private fun hideShimmerAndAlbumsRecycler() {
        homeBinding.rvShimmer.visibility = View.GONE
        homeBinding.albumsRV.visibility = View.VISIBLE
        homeBinding.myAlbumsShimmer.visibility = View.GONE
        homeBinding.txtMyAlbumes.visibility = View.VISIBLE
    }

    private fun hideUserShimmerAndShowUserData() {
        homeBinding.nameShimmer.visibility = View.GONE
        homeBinding.zipCodeShimmer.visibility = View.GONE
        homeBinding.AddressShimmer.visibility = View.GONE
        homeBinding.txtuserName.visibility = View.VISIBLE
        homeBinding.txtUserAddress.visibility = View.VISIBLE
        homeBinding.txtUserPhone.visibility = View.VISIBLE
    }

    /**
     * show error splash if the api call was fail
     */
    private fun showErrorSplash() {
        homeBinding.nameShimmer.visibility = View.GONE
        homeBinding.zipCodeShimmer.visibility = View.GONE
        homeBinding.AddressShimmer.visibility = View.GONE
        homeBinding.txtuserName.visibility = View.GONE
        homeBinding.txtUserAddress.visibility = View.GONE
        homeBinding.txtUserPhone.visibility = View.GONE
        homeBinding.rvShimmer.visibility = View.GONE
        homeBinding.albumsRV.visibility = View.GONE
        homeBinding.myAlbumsShimmer.visibility = View.GONE
        homeBinding.txtMyAlbumes.visibility = View.GONE
        homeBinding.homeErrorSplash.visibility = View.VISIBLE
    }
}