package com.madhu.newsapp2.ui.repository

import com.madhu.newsapp2.data.datasource.NewsDataSource
import com.madhu.newsapp2.data.entity.NewsResponse
import com.madhu.newsapp2.utility.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

//    suspend fun getHeadlines(country:String): Response<NewsResponse>{
//        return newsDataSource.getHeadlines(country)
//    }


    suspend fun getHeadlines(country:String):Flow<ResourceState<NewsResponse>>{

        return  flow {
            emit(ResourceState.Loading())

            val response = newsDataSource.getHeadlines(country)

            if(response.isSuccessful && response.body()!=null){
                emit(ResourceState.Success(response.body()!!))
            }else{
                emit(ResourceState.Error("Error Fetching data "))
            }
        }.catch{e->
            emit(ResourceState.Error(e?.localizedMessage?:"Some Error"))
        }

    }



}