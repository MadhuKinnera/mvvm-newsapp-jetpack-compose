package com.madhu.newsapp2.data.api

import com.madhu.newsapp2.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/top-headlines")
   suspend fun getHeadlines(
        @Query("country")  country:String,
        @Query("apiKey")  apiKey: String = "c32de693de9c46b2aa533269912587de"
    ):Response<NewsResponse>

}
//https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=c32de693de9c46b2aa533269912587de
//https://newsapi.org/v2/top-headlines?country=us&apiKey=c32de693de9c46b2aa533269912587de