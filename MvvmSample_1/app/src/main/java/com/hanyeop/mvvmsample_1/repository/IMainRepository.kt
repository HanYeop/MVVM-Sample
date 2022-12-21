package com.hanyeop.mvvmsample_1.repository

import com.hanyeop.mvvmsample_1.model.Post

interface IMainRepository {
    suspend fun getPosts(userId : Int): List<Post>
}