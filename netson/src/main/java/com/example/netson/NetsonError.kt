package com.example.netson

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NetsonError(
    @SerializedName("status_code")
    var statusCode: String? = null,
    @SerializedName("status_message")
    var statusMessage: String? = null,
    @SerializedName("errorSource")
    var errorSource: String? = null,
    @SerializedName("success")
    var success: Boolean? = null
) : Parcelable {
    constructor(statusMsg: String?) : this(statusMessage = statusMsg)
}