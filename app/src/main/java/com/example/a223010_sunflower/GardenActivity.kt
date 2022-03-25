package com.example.a223010_sunflower

import androidx.databinding.DataBindingUtil


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a223010_sunflower.adapters.SunflowerPagerAdapter
import com.example.a223010_sunflower.databinding.ActivityGardenBinding
import com.example.a223010_sunflower.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


//프래그먼트를 갖고잇는 엑티비티에서도 어노테이션을 선언해주어야 함.
//의존성을 얻기 위해서 사용
@AndroidEntryPoint
class GardenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGardenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_garden)
    }


}