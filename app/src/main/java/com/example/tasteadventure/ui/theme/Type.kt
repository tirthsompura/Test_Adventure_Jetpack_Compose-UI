package com.example.tasteadventure.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tasteadventure.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val fontRegularOld by lazy {
    TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = FontWeight(400),
        fontSize = 14.sp,
        lineHeight=20.sp,
        color = colorBlack
    )
}

val fontRegular by lazy {
    TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium)),
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        lineHeight=20.sp,
        color = colorBlack
    )
}


val fontMedium by lazy {
    TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_semi_bold)),
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
        lineHeight=20.sp,
        color = colorBlack
    )
}

val fontSemiBold by lazy {
    TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        fontWeight = FontWeight(700),
        fontSize = 24.sp,
        lineHeight= 32.sp,
        color = colorBlack
    )
}