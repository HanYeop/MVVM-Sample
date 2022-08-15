package com.hanyeop.mvvmsample_4.view.three

import android.util.Log
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.base.BaseFragmentMain
import com.hanyeop.mvvmsample_4.databinding.FragmentThreeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThreeFragment : BaseFragmentMain<FragmentThreeBinding>(R.layout.fragment_three) {
    override fun init() {

    }

    override fun onResume() {
        super.onResume()
        Log.d("ThreeFragment", "onResume: 3")
    }
}