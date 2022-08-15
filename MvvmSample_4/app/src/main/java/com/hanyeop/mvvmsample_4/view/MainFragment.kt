package com.hanyeop.mvvmsample_4.view

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.base.BaseFragmentMain
import com.hanyeop.mvvmsample_4.databinding.FragmentMainBinding
import com.hanyeop.mvvmsample_4.utils.KeepStateNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragmentMain<FragmentMainBinding>(R.layout.fragment_main) {

    override fun init() {
        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.main_navigation_view) as NavHostFragment
        val navController = navHostFragment.navController
        val keepStateNavigator = KeepStateNavigator(
            requireContext(),
            childFragmentManager,
            R.id.main_navigation_view
        )
        navController.navigatorProvider.addNavigator(keepStateNavigator)
        navController.setGraph(R.navigation.navi_graph_bottom)
        binding.mainBottomNavigation.setupWithNavController(navController)
    }
}