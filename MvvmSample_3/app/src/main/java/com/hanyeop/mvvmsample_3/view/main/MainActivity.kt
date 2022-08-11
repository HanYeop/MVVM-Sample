package com.hanyeop.mvvmsample_3.view.main

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hanyeop.mvvmsample_3.R
import com.hanyeop.mvvmsample_3.base.BaseActivity
import com.hanyeop.mvvmsample_3.databinding.ActivityMainBinding
import com.hanyeop.mvvmsample_3.utils.repeatOnStarted
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
        initViewModelCallback()
    }

    private fun initViewModelCallback(){

        // 생명주기에 맞춰 코루틴을 취소한다.
        repeatOnStarted{
            mainViewModel.errorMsg.collectLatest { msg ->
                showToast(msg)
            }
        }
        repeatOnStarted{
            mainViewModel.postList.collectLatest { list ->
                mainAdapter.submitList(list)
            }
        }

        // 생명주기에 맞춰 코루틴을 일시 중지한다.
        lifecycleScope.launchWhenStarted {

        }
    }
}