package com.hanyeop.mvvmsample_3.api

import com.hanyeop.mvvmsample_3.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {
    @GET("posts")
    suspend fun getPosts(
        @Query("userId") userId : Int
    ): List<Post>
}