package com.hanyeop.mvvmsample_4.view.one

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.base.BaseFragmentMain
import com.hanyeop.mvvmsample_4.databinding.FragmentOneBinding
import com.hanyeop.mvvmsample_4.model.Post
import com.hanyeop.mvvmsample_4.utils.repeatOnStarted
import com.hanyeop.mvvmsample_4.view.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class OneFragment : BaseFragmentMain<FragmentOneBinding>(R.layout.fragment_one) {

    private val oneViewModel by viewModels<OneViewModel>()
    private lateinit var oneAdapter: OneAdapter

    override fun init() {
        oneAdapter = OneAdapter(listener)

        binding.apply {
            vm = oneViewModel
            recyclerView.adapter = oneAdapter
        }
        initViewModelCallback()
    }

    private fun initViewModelCallback(){
        // 생명주기에 맞춰 코루틴을 취소, 시작 한다.
        repeatOnStarted{
            oneViewModel.errorMsg.collectLatest { msg ->
                showToast(msg)
            }
        }
        repeatOnStarted{
            oneViewModel.postList.collectLatest { list ->
                oneAdapter.submitList(list)
            }
        }

        // 생명주기에 맞춰 코루틴을 일시 중지, 다시 시작한다.
        lifecycleScope.launchWhenStarted {

        }
    }

    private val listener = object : OneListener{
        override fun onItemClick(post: Post) {
            val action = MainFragmentDirections.actionMainFragmentToOneDetailFragment(post)
            findNavController().navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("OneFragment", "onResume: 1")
    }
}