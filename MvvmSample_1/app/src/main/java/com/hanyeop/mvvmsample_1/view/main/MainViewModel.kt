package com.hanyeop.mvvmsample_1.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.mvvmsample_1.model.Post
import com.hanyeop.mvvmsample_1.repository.IMainRepository
import com.hanyeop.mvvmsample_1.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: IMainRepository = MainRepository.get()
): ViewModel() {

    private val _myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    val myResponse : LiveData<List<Post>>  get() = _myResponse

    val editTextView: MutableLiveData<String> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getPosts(editTextView.value.toString().toInt()).let { response ->
                _myResponse.postValue(response)
            }
        }
    }

    fun getDefaultPost(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getPosts(1).let { response ->
                _myResponse.postValue(response)
            }
        }
    }
}