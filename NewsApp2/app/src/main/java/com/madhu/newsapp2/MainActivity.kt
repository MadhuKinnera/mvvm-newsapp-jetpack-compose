package com.madhu.newsapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madhu.newsapp2.ui.navigation.AppNavigationGraph
import com.madhu.newsapp2.ui.theme.NewsApp2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp2Theme {
                Surface(modifier = Modifier
                    .fillMaxSize()) {
                    AppEntryPoint()
                }


            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}