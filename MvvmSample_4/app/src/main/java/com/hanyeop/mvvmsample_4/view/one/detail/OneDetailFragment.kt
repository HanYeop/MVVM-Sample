package com.hanyeop.mvvmsample_4.view.one.detail

import androidx.navigation.fragment.navArgs
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.base.BaseFragment
import com.hanyeop.mvvmsample_4.databinding.FragmentOneDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OneDetailFragment : BaseFragment<FragmentOneDetailBinding>(R.layout.fragment_one_detail) {

    private val args by navArgs<OneDetailFragmentArgs>()

    override fun init() {
        binding.apply {
            post = args.post
        }
    }
}