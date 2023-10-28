package com.madhu.newsapp2.data.datasource

import com.madhu.newsapp2.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getHeadlines(country:String): Response<NewsResponse>
}