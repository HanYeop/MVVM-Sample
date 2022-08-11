package com.hanyeop.mvvmsample_3.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.mvvmsample_3.model.Post
import com.hanyeop.mvvmsample_3.utils.ResultType
import com.hanyeop.mvvmsample_3.view.main.MainAdapter

// XML 에서 직접 리스트를 바인드 하는 방법
object RecyclerViewBinding {
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