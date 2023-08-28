package com.wahyus.ytmp3example.network.retrofit

import com.wahyus.ytmp3example.network.response.DataMp3
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "X-RapidAPI-Key: 175ab9dc33mshbcc77c8fd79a44bp1363a4jsnc427bef603c4",
        "X-RapidAPI-Host: youtube-mp3-download-highest-quality1.p.rapidapi.com"
    )
    @GET("/ytmp3/ytmp3/custom/?")
    fun getData(
        @Query("url") url: String,
        @Query("quality") quality: Int
    ): Call<DataMp3>
}