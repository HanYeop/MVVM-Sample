package com.hanyeop.mvvmsample_1.api

import com.hanyeop.mvvmsample_1.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

// 가능한 HTTP 동작들을 정의해놓은 인터페이스
interface SimpleApi {
    @GET("posts")
    suspend fun getPosts(
        @Query("userId") userId : Int
    ): List<Post>
}