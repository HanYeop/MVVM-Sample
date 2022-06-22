package com.hanyeop.mvvmsample_1.repository

import com.hanyeop.mvvmsample_1.api.RetrofitInstance
import com.hanyeop.mvvmsample_1.model.Post
import retrofit2.Response

class MainRepository {
    suspend fun getPosts(userId : Int): Response<List<Post>> = RetrofitInstance.api.getPosts(userId)

    // 싱글톤
    companion object {
        private var INSTANCE: MainRepository? = null

        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = MainRepository()
            }
        }

        fun get(): MainRepository {
            return INSTANCE ?:
            throw IllegalStateException("Repository must be initialized")
        }
    }
}