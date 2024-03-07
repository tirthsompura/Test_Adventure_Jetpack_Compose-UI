package com.example.tasteadventure.presentation.splashscreen

import androidx.lifecycle.ViewModel
import com.example.tasteadventure.util.SessionManagerClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    val sessionManagerClass: SessionManagerClass
) : ViewModel() {

}