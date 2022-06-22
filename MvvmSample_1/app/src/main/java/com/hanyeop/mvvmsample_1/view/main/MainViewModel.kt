package com.hanyeop.mvvmsample_1.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanyeop.mvvmsample_1.model.Post
import com.hanyeop.mvvmsample_1.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val mainRepository = MainRepository.get()

    private val _myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    val myResponse : LiveData<List<Post>>  get() = _myResponse

    val editTextView: MutableLiveData<String> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getPosts(editTextView.value.toString().toInt()).let { response ->
                if(response.isSuccessful){
                    _myResponse.postValue(response.body())
                }else{
                    // TODO : Error
                }
            }
        }
    }
}