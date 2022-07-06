package com.hanyeop.mvvmsample_2.api

import com.hanyeop.mvvmsample_2.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApi {
    @GET("posts")
    suspend fun getPosts(
        @Query("userId") userId : Int
    ): List<Post>
}