package com.hanyeop.mvvmsample_2.view.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ListAdapter
import com.hanyeop.mvvmsample_2.R
import com.hanyeop.mvvmsample_2.base.BaseActivity
import com.hanyeop.mvvmsample_2.databinding.ActivityMainBinding
import com.hanyeop.mvvmsample_2.utils.ResultType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    private val mainAdapter = MainAdapter()

    override fun init() {
        binding.apply {
            vm = mainViewModel
            recyclerView.adapter = mainAdapter
        }

//        initViewModelCallback()
    }

//    // 2번 방법
//    private fun initViewModelCallback(){
//        lifecycleScope.launchWhenStarted {
//            mainViewModel.myResponse.collectLatest {
//                if(it is ResultType.Success){
//                    mainAdapter.submitList(it.data)
//                }else if (it is ResultType.Empty) {
//                    mainAdapter.submitList(emptyList())
//                }
//            }
//        }
//    }
}