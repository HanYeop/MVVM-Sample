package com.hanyeop.mvvmsample_1.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hanyeop.mvvmsample_1.R
import com.hanyeop.mvvmsample_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.lifecycleOwner = this

        init()
    }

    private fun init(){
        binding.apply {
            vm = mainViewModel
            recyclerView.adapter = mainAdapter
        }
        initViewModelCallback()
    }

    private fun initViewModelCallback(){
        mainViewModel.myResponse.observe(this){
            mainAdapter.setData(it)
        }
    }
}