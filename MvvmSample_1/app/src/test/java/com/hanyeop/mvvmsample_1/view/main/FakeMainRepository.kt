package com.hanyeop.mvvmsample_1.view.main

import com.hanyeop.mvvmsample_1.model.Post
import com.hanyeop.mvvmsample_1.repository.IMainRepository
import kotlinx.coroutines.delay

class FakeMainRepository : IMainRepository {

    private val posts = mutableListOf<Post>()

    init {
        posts.add(Post(0, 11, "타이틀1", "바디1"))
        posts.add(Post(1, 22, "타이틀2", "바디2"))
        posts.add(Post(2, 33, "타이틀3", "바디3"))
    }

    override suspend fun getPosts(userId: Int): List<Post> {
        delay(1000L)
        return posts
    }

}