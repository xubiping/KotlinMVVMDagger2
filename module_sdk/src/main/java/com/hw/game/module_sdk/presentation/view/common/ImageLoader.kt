package com.hw.game.module_sdk.presentation.view.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ImageLoader @Inject constructor(val content:Context) {
    fun loadImage(imageView: ImageView,imageUrl:String){
        Glide.with(content).load(imageUrl)
            .thumbnail(0.5f)//缩略图 传了0.1f作为参数，那么Glide则会显示原图大小的10%，0.5原图50%的大小
            .into(imageView)
    }
}