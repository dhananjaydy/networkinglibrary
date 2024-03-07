package com.example.netson

import okhttp3.OkHttpClient

object APIFactory {

    inline fun <reified T> provideRetrofitService(baseUrl: String): T {
        return RetrofitHelper.provideRetrofit(baseUrl, provideClient()).create(T::class.java)
    }

    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

}