package com.hanyeop.mvvmsample_2.repository

import com.hanyeop.mvvmsample_2.datasource.main.MainRemoteDataSource
import com.hanyeop.mvvmsample_2.model.Post
import com.hanyeop.mvvmsample_2.utils.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainRemoteDataSource: MainRemoteDataSource
)  {
    fun getPosts(userId : Int): Flow<ResultType<List<Post>>> = flow {
        emit(ResultType.Loading)
        mainRemoteDataSource.getPosts(userId).collect {
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