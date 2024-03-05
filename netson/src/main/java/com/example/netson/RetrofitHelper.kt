package com.example.netson

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun provideRetrofit(baseURL: String, okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().serializeNulls().create()
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .build()
    }

    fun provideRetrofitNoCallAdapter(baseURL: String, okHttpClient: OkHttpClient): Retrofit {
        val gson = GsonBuilder().serializeNulls().create()
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

}