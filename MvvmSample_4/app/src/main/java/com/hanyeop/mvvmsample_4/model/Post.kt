package com.hanyeop.mvvmsample_4.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    @SerializedName("userId")
    val myUserId : Int,
    val id : Int,
    val title : String,
    val body : String
): Parcelable
