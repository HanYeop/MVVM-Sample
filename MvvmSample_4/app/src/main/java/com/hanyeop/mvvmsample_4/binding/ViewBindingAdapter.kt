package com.hanyeop.mvvmsample_4.binding

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.hanyeop.mvvmsample_4.R
import com.hanyeop.mvvmsample_4.utils.ResultType

// XML 에서 로딩, 에러메세지 직접 바인딩하는 방법
object ViewBindingAdapter {

    // 로딩 상태 표시
    @JvmStatic
    @BindingAdapter("isLoading")
    fun View.setIsLoading(result: ResultType<*>) {
        this.isVisible = result is ResultType.Loading
    }

    // 에러 메세지 표시
    @JvmStatic
    @BindingAdapter("toast")
    fun View.bindToast(result: ResultType<*>) {
        if (result is ResultType.Error) {
            if (result.isNetworkError) {
                Toast.makeText(this.context, R.string.error_network, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.context, R.string.error_unknown, Toast.LENGTH_SHORT).show()
            }
        }
        else if(result is ResultType.Empty){
            Toast.makeText(this.context, R.string.error_empty, Toast.LENGTH_SHORT).show()
        } else if (result is ResultType.InputError){
            Toast.makeText(this.context, R.string.error_input, Toast.LENGTH_SHORT).show()
        }
    }
}