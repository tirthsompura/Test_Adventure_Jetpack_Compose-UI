package com.example.tasteadventure.presentation.util

import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


// Observe keyboard visibility
@Composable
fun keyboardVisibility(): LiveData<Boolean> {
    val isKeyboardVisible = MutableLiveData<Boolean>()

    val view = LocalView.current
    val viewTreeObserver = view.viewTreeObserver

    DisposableEffect(viewTreeObserver) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val isKeyboardOpen = ViewCompat.getRootWindowInsets(view)
                ?.isVisible(WindowInsetsCompat.Type.ime()) ?: true
            isKeyboardVisible.value = isKeyboardOpen
        }

        viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
    return isKeyboardVisible
}
