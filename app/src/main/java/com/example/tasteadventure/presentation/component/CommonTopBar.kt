package com.example.tasteadventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasteadventure.R
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.colorBlack
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.menuBgColor

@Composable
fun CommonTopBar(
    isFirstIconShow: Boolean = false,
    isSecondIconShow: Boolean = false,
    isBothIconShow: Boolean = false,
    isAllMenuShow: Boolean = false,
    isFirstIconWithText: Boolean = false,
    isTitle: String = "",
    firstIcon: Painter = painterResource(id = R.drawable.ic_setting),
    secondIcon: Painter = painterResource(id = R.drawable.ic_bag),
    firstIconClick: () -> Unit,
    secondIconClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Transparent)
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = if (isAllMenuShow) Arrangement.SpaceBetween else Arrangement.SpaceBetween
    ) {
        if (isFirstIconShow) {
            menuButtonWithBg(icon = firstIcon) { firstIconClick() }
            Box(
                modifier = Modifier
                    .size(50.dp)
            ) {}
        } else if (isSecondIconShow) {
            Box(
                modifier = Modifier
                    .size(50.dp)
            ) {}
            menuButtonWithBg(icon = secondIcon) { secondIconClick() }
        } else if (isBothIconShow) {
            menuButtonWithBg(icon = firstIcon) { firstIconClick() }
            menuButtonWithBg(icon = secondIcon) { secondIconClick() }
        } else if (isFirstIconWithText) {
            menuButtonWithBg(icon = firstIcon) { firstIconClick() }
            NormalText(
                label = isTitle,
                style = fontMedium.copy(color = bottomBarBGColor, fontSize = 25.sp),
                maxLine = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
            ) {}
        } else {
            if (isAllMenuShow) {
                menuButtonWithBg(icon = firstIcon) { firstIconClick() }
                NormalText(
                    label = isTitle,
                    style = fontMedium.copy(color = bottomBarBGColor, fontSize = 25.sp),
                    maxLine = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                menuButtonWithBg(icon = secondIcon) { secondIconClick() }
            }
        }
    }
}

@Composable
fun menuButtonWithBg(
    bgColor: Color = menuBgColor,
    icon: Painter,
    iconTintColor: Color = colorBlack,
    onIconClick: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(shape = RoundedCornerShape(100.dp))
            .background(bgColor)
            .padding(10.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onIconClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = "",
            colorFilter = ColorFilter.tint(iconTintColor)
        )
    }
}