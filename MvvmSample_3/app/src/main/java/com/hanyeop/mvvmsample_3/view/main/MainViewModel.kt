package com.hanyeop.mvvmsample_3.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.mvvmsample_3.model.Post
import com.hanyeop.mvvmsample_3.usecase.post.GetPostsUseCase
import com.hanyeop.mvvmsample_3.utils.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// UseCase -> ViewModel
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
): ViewModel() {

    private val _postList: MutableStateFlow<List<Post>> = MutableStateFlow(listOf())
    val postList get() = _postList.asStateFlow()

    private val _errorMsg = MutableSharedFlow<String>()
    val errorMsg = _errorMsg.asSharedFlow()

    private val _getPostsResult: MutableStateFlow<ResultType<List<Post>>> = MutableStateFlow(ResultType.Uninitialized)
    val getPostsResult get() = _getPostsResult.asStateFlow()

    val editTextView: MutableStateFlow<String> = MutableStateFlow("")

    fun getPosts(){
        viewModelScope.launch(Dispatchers.IO) {
            if(editTextView.value == ""){
                _errorMsg.emit("입력을 확인해주세요")
            }
            else {
                getPostsUseCase.execute(editTextView.value.toInt()).collectLatest {
                    _getPostsResult.value = it
                    when (it) {
                        is ResultType.Success -> {
                            _postList.value = it.data
                        }
                        is ResultType.Empty -> {
                            _errorMsg.emit("검색 결과가 없습니다.")
                        }
                        is ResultType.Error -> {
                            _errorMsg.emit("에러 발생.")
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}