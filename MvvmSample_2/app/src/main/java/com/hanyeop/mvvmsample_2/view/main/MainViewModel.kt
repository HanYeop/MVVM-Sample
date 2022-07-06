package com.hanyeop.mvvmsample_2.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.mvvmsample_2.model.Post
import com.hanyeop.mvvmsample_2.repository.MainRepository
import com.hanyeop.mvvmsample_2.utils.ResultType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _myResponse: MutableStateFlow<ResultType<List<Post>>> = MutableStateFlow(ResultType.Uninitialized)
    val myResponse get() = _myResponse.asStateFlow()

    val editTextView: MutableStateFlow<String> = MutableStateFlow("")

    fun getPosts(){
        if(editTextView.value == ""){
            _myResponse.value = ResultType.InputError
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                mainRepository.getPosts(editTextView.value.toInt()).collectLatest {
                    _myResponse.value = it
                }
            }
        }
    }
}