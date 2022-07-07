package com.hanyeop.mvvmsample_2.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.mvvmsample_2.model.Post
import com.hanyeop.mvvmsample_2.utils.ResultType
import com.hanyeop.mvvmsample_2.view.main.MainAdapter

object RecyclerViewBinding {

    // 1번 방법
    @JvmStatic
    @BindingAdapter("submitList")
    fun bindSubmitList(view: RecyclerView, result: ResultType<*>) {
        if (result is ResultType.Success) {
            when (view.adapter) {
                is MainAdapter -> {
                    (view.adapter as ListAdapter<Any, *>).submitList(result.data as List<Post>)
                }
            }
        } else if (result is ResultType.Empty) {
            (view.adapter as ListAdapter<Any, *>).submitList(emptyList())
        }
    }
}