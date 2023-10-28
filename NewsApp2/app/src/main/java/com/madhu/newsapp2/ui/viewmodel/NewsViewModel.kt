package com.madhu.newsapp2.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madhu.newsapp2.data.entity.NewsResponse
import com.madhu.newsapp2.ui.repository.NewsRepository
import com.madhu.newsapp2.utility.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {


    private val _news : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news:StateFlow<ResourceState<NewsResponse>> = _news


    init {
        Log.d("NewsViewModel","News View Model Initiated ")
        getNews("us")
    }


    private fun getNews(country:String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getHeadlines(country)
                .collectLatest { newsResponse ->
                    _news.value =newsResponse

                }
        }
    }


}