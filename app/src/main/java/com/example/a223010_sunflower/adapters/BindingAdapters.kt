package com.example.a223010_sunflower.adapters

import android.view.View
import androidx.databinding.BindingAdapter

// TODO: 2022-03-23 모르는 부분 bindingAdapter 
@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}