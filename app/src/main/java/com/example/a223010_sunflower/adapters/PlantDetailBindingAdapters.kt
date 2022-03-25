package com.example.a223010_sunflower.adapters

import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.a223010_sunflower.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: 2022-03-23 BindingAdapter, Glide.Transition 사용공부
@BindingAdapter("imageFromUrl")
//식물정보 리사이클러뷰 아이템뷰에 Url을 입력하여
//DataBinding을 할 때 사용
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    //이미지 Url이 있는 경우에만
    if (!imageUrl.isNullOrEmpty()) {
        //이미지 로딩
        Glide
            .with(view.context)
            .load("이미지 url")
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("isFabGone")
fun bindIsFabGone(view: FloatingActionButton, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.hide()
    } else {
        view.show()
    }
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

@BindingAdapter("wateringText")
fun bindWateringText(textView: TextView, wateringInterval: Int) {
    val resources = textView.context.resources
    val quantityString = resources.getQuantityString(
        R.plurals.watering_needs_suffix,
        wateringInterval,
        wateringInterval
    )

    textView.text = quantityString
}