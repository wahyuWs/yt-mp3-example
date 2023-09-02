package com.wahyus.ytmp3example.network.retrofit

import com.wahyus.ytmp3example.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val loggingInterceptor = if (BuildConfig.DEBUG) {
                                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                                    } else {
                                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                                    }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}