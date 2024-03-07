package com.example.tasteadventure.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.tasteadventure.ui.theme.dividerColorHome

@Composable
fun CommonDivider(modifier: Modifier){
    Divider(color = dividerColorHome, modifier = modifier)
}

@Composable
fun SpacerVertical(height: Dp){
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerHorizontal(width: Dp){
    Spacer(modifier = Modifier.width(width))
}
@Composable
fun SpacerHeight(height : Dp){
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(width : Dp){
    Spacer(modifier = Modifier.width(width))
}