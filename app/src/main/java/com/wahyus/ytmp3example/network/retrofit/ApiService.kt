package com.wahyus.ytmp3example.network.retrofit

import com.wahyus.ytmp3example.BuildConfig
import com.wahyus.ytmp3example.network.response.DataMp3
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: ${BuildConfig.rapidapikey}",
        "X-RapidAPI-Host: ${BuildConfig.rapidapihost}"
    )
    @GET(BuildConfig.endpoint)
    fun getData(
        @Query("url") url: String,
        @Query("quality") quality: Int
    ): Call<DataMp3>
}