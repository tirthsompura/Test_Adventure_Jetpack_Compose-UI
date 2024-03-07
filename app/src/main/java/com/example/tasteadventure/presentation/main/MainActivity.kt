package com.example.tasteadventure.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleObserver
import com.example.tasteadventure.presentation.splashscreen.SplashScreenViewModel
import com.example.tasteadventure.presentation.util.RootNavGraph
import com.example.tasteadventure.ui.theme.TasteAdventureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(), LifecycleObserver {

    private val viewModelSplashScreenViewModel: SplashScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasteAdventureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavGraph(viewModelSplashScreenViewModel.sessionManagerClass)
                }
            }
        }
    }
}