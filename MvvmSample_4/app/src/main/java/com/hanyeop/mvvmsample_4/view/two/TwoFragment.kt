package com.hanyeop.mvvmsample_4.view.two

import android.util.Log
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.base.BaseFragmentMain
import com.hanyeop.mvvmsample_4.databinding.FragmentTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TwoFragment : BaseFragmentMain<FragmentTwoBinding>(R.layout.fragment_two) {
    override fun init() {

    }

    override fun onResume() {
        super.onResume()
        Log.d("TwoFragment", "onResume: 2")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TwoFragment", "onDestroyView: 2")
    }
}