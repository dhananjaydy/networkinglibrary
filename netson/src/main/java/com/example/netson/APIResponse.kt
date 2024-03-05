package com.example.netson

import com.google.gson.annotations.SerializedName

open class APIResponse<T>(
    @SerializedName("data")
    val data: T,
    @SerializedName("error")
    val error: NetsonError,
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("serverTimeStamp")
    val serverTimeStamp: Long? = null
)
