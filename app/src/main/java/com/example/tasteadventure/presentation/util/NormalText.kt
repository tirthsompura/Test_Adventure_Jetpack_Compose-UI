package com.example.tasteadventure.presentation.util

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun NormalText(
    label: String,
    modifier: Modifier = Modifier,
    style: TextStyle,
    maxLine: Int = 1,
    textAlign: TextAlign? = null
) {
    Text(
        text = label,
        modifier = modifier,
        style = style,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        textAlign = textAlign,
    )
}