package com.hanyeop.mvvmsample_1.view.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.hanyeop.mvvmsample_1.model.Post
import com.hanyeop.mvvmsample_1.view.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        val fakeMainRepository = FakeMainRepository()

        viewModel = MainViewModel(fakeMainRepository)
    }

    @Test
    fun getPosts_returnsCurrentList(){
        val posts = mutableListOf<Post>()
        posts.add(Post(0, 11, "타이틀1", "바디1"))
        posts.add(Post(1, 22, "타이틀2", "바디2"))
        posts.add(Post(2, 33, "타이틀3", "바디3"))

        viewModel.getDefaultPost()
        val currentList = viewModel.myResponse.getOrAwaitValue()
        assertThat(currentList).isEqualTo(posts)
    }
}