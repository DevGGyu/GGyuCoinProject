package com.project.ggyucoinproject.etc

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object CommonBindingAdapter {

    @JvmStatic
    @BindingAdapter("symbol")
    fun setSymbol(view: ImageView, market: String?) {
        val name = market?.substringAfterLast("-")
        Glide.with(view.context)
            .load("https://static.upbit.com/logos/${name}.png")
            .into(view)
    }
}