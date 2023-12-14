package com.example.bostatask.detailsScreen.presention

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bostatask.R
import com.example.bostatask.databinding.PhotoItemBinding
import com.example.bostatask.detailsScreen.model.PhotosItem

/**
 * PhotosAdapter that responsible for display selected album photos
 * @param photosList the data should be shown
 * @param onClickToShowImage instance of OnClickToShowImage interface to pass the selected photo to
 * details fragment for navigation
 */
class PhotosAdapter(
    private var photosList: List<PhotosItem>,
    private val onClickToShowImage: OnClickToShowImage
) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        Glide.with(holder.binding.root).load(photosList[position].url)
            .placeholder(R.drawable.placholder)
            .into(holder.binding.photoImg)

        holder.binding.photoImg.setOnClickListener {
            onClickToShowImage.showImage(photosList[position])
        }

    }

    fun updateList(photosList: List<PhotosItem>) {
        this.photosList = photosList
        notifyDataSetChanged()
    }

    inner class PhotosViewHolder(val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}