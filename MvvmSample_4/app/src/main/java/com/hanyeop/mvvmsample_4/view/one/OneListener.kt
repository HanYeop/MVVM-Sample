package com.hanyeop.mvvmsample_4.view.one

import com.hanyeop.mvvmsample_4.model.Post

interface OneListener {
    fun onItemClick(post: Post)
}