package com.hanyeop.mvvmsample_3.repository

import com.hanyeop.mvvmsample_3.datasource.post.remote.PostRemoteDataSource
import com.hanyeop.mvvmsample_3.model.Post
import com.hanyeop.mvvmsample_3.utils.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

// Datasource -> Repository (ResultType)
@Singleton
class PostRepository @Inject constructor(
    private val postRemoteDataSource: PostRemoteDataSource
)  {
    fun getPosts(userId : Int): Flow<ResultType<List<Post>>> = flow {
        emit(ResultType.Loading)
        postRemoteDataSource.getPosts(userId).collect {
            if(it.isEmpty()){
                emit(ResultType.Empty)
            }else{
                emit(ResultType.Success(it))
            }
        }
    }.catch { e ->
        emit(ResultType.Error(e))
    }
}