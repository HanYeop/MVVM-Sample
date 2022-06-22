package com.hanyeop

import android.app.Application
import com.hanyeop.mvvmsample_1.repository.MainRepository

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()

        initRepository()
    }
    private fun initRepository(){
        MainRepository.initialize()
    }
}