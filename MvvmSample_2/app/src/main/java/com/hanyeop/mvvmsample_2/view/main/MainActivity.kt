package com.hanyeop.mvvmsample_2.view.main

import androidx.activity.viewModels
import com.hanyeop.mvvmsample_2.R
import com.hanyeop.mvvmsample_2.base.BaseActivity
import com.hanyeop.mvvmsample_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun init() {
        binding.apply {
            vm = mainViewModel
            recyclerView.adapter = mainAdapter
        }
    }
}