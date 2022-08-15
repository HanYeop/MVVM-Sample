package com.hanyeop.mvvmsample_4.usecase

import com.hanyeop.mvvmsample_4.repository.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

// Repository -> UseCase (한 기능으로 분리하기 위함)
@Singleton
class GetPostsUseCase @Inject constructor(private val postRepository: PostRepository){
    fun execute(userId: Int) = postRepository.getPosts(userId)
}