package com.madhu.newsapp2.data.datasource

import com.madhu.newsapp2.data.api.ApiService
import com.madhu.newsapp2.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {
    override suspend fun getHeadlines(country: String): Response<NewsResponse> {

        return apiService.getHeadlines(country)
    }

}