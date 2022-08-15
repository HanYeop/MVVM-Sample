package com.hanyeop.mvvmsample_4.repository

import com.hanyeop.mvvmsample_4.datasource.PostRemoteDataSource
import com.hanyeop.mvvmsample_4.model.Post
import com.hanyeop.mvvmsample_4.utils.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
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