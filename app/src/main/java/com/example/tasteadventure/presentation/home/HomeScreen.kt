package com.example.tasteadventure.presentation.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.tasteadventure.presentation.component.ChangeStatusBarColor
import com.example.tasteadventure.util.SessionManagerClass

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController, sessionManagerClass: SessionManagerClass) {
    Scaffold(
        topBar = {},
        content = {
            ChangeStatusBarColor()

        }
    )

}