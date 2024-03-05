package com.example.netson

import okhttp3.OkHttpClient

object APIFactory {

    inline fun <reified T> provideRetrofit(endPoint: String, okHttpClient: OkHttpClient): T {
        val retrofit = RetrofitHelper.provideRetrofit(endPoint, okHttpClient)
        return retrofit.create(T::class.java)
    }
}