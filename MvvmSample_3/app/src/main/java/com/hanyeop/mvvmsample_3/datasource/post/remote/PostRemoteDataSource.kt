package com.hanyeop.mvvmsample_3.datasource.post.remote

import com.hanyeop.mvvmsample_3.api.PostApi
import com.hanyeop.mvvmsample_3.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

// API -> DataSource (Flow)
@Singleton
class PostRemoteDataSource @Inject constructor(
    private val postApi: PostApi
) {
    fun getPosts(userId : Int): Flow<List<Post>> = flow {
        emit(postApi.getPosts(userId))
    }
}