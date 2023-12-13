package com.example.bostatask.common.util

import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.bostatask.detailsScreen.model.PhotosItem

fun Fragment.shareImageUrl(image:PhotosItem) {
    try {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, image.url)
        val shareMessage = "i want share with you this image link ${image.url}"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "choose one"))
    } catch (e: java.lang.Exception) {
       Log.i("ShareError",e.toString())
    }
}
