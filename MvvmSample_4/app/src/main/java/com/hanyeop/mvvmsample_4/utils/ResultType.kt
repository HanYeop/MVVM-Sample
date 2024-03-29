package com.hanyeop.mvvmsample_4.utils

import java.io.IOException

sealed class ResultType<out T> {
    object Uninitialized : ResultType<Nothing>()

    object Loading : ResultType<Nothing>()

    object Empty : ResultType<Nothing>()

    object InputError : ResultType<Nothing>()

    data class Success<T>(val data: T) : ResultType<T>()

    data class Error(val exception: Throwable) : ResultType<Nothing>() {
        val isNetworkError = exception is IOException
    }
}
