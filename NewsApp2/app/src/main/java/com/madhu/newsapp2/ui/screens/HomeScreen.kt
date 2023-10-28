package com.madhu.newsapp2.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.madhu.newsapp2.data.entity.NewsResponse
import com.madhu.newsapp2.ui.viewmodel.NewsViewModel
import com.madhu.newsapp2.utility.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    Log.d("HomeScreen", "Inside Home Screen")
    val newsResponse by newsViewModel.news.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        when (newsResponse) {
            is ResourceState.Loading -> {
                Text(text = "Loading ....")
            }

            is ResourceState.Success -> {
                Column {
                    Text(text = "Data Fetched Success ")
                    Text(text = (newsResponse as ResourceState.Success<NewsResponse>).data.toString())

                }
            }

            is ResourceState.Error -> {
                Column {
                    Text(text = "Some thing went wrong ")
                    Text(text = (newsResponse as ResourceState.Error<NewsResponse>).error)
                }
              
                
            }
        }
    }
}