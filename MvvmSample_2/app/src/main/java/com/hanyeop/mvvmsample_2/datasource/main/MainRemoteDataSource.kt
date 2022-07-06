package com.hanyeop.mvvmsample_2.datasource.main

import com.hanyeop.mvvmsample_2.api.SimpleApi
import com.hanyeop.mvvmsample_2.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRemoteDataSource @Inject constructor(
    private val simpleApi: SimpleApi
) {
    fun getPosts(userId : Int): Flow<List<Post>> = flow {
        emit(simpleApi.getPosts(userId))
    }
}