package com.example.tasteadventure.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.buttonGradientColor1
import com.example.tasteadventure.ui.theme.buttonGradientColor2
import com.example.tasteadventure.ui.theme.colorBlack
import com.example.tasteadventure.ui.theme.commonBackground
import com.example.tasteadventure.ui.theme.customPrimaryColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.indicatorActiveColor
import com.example.tasteadventure.ui.theme.whiteColor

@Composable
fun RoundedBackgroundButton(
    label: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    paddingTop: Dp = 8.dp,
    paddingBottom: Dp = 11.dp,
    cornerRadius: Dp = 12.dp,
    onClick: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Button(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {}
            )
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = whiteColor
        ),
        elevation = null,
        shape = RoundedCornerShape(cornerRadius),
        contentPadding = PaddingValues(0.dp),
        onClick = onClick
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(top = paddingTop, bottom = paddingBottom),
            style = style,
        )
    }
}

@Composable
fun RoundedImageWithBackground(icon: Painter, boxSize: Dp, inPadding: Dp, function: () -> Unit) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Card(
        modifier = Modifier.size(boxSize),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .padding(inPadding)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = function
                ),
        )
    }
}

@Composable
fun GradientButton(
    backgroundColor: Color = indicatorActiveColor,
    style: TextStyle,
    label: String,
    buttonHeight: Dp = 50.dp,
    borderRadious: Dp = 12.dp,
    modifier: Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(shape = RoundedCornerShape(borderRadious))
            .background(backgroundColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = style,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun IconWithTextButton(
    text: String,
    style: TextStyle,
    borderColor: Color,
    bgColor: Color,
    buttonHeight: Dp = 50.dp,
    borderShape: Dp,
    icon: Painter,
    onClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(shape = RoundedCornerShape(borderShape))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(borderShape))
            .background(bgColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = icon,
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            SpacerHorizontal(width = 8.dp)
            NormalText(
                label = text,
                style = style
            )
        }
    }
}

@Composable
fun GradientButtonWithIcon(
    gradientColors: List<Color> = listOf(
        buttonGradientColor1, buttonGradientColor2
    ),
    icon: Painter?,
    backgroundColor: Color = customPrimaryColor,
    style: TextStyle,
    label: String,
    buttonHeight: Dp = 40.dp,
    modifier: Modifier,
    cornerRadius: Dp = 12.dp,
    onClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(shape = RoundedCornerShape(cornerRadius))
            .border(
                width = 2.dp,
                brush = Brush.verticalGradient(colors = gradientColors),
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(backgroundColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Image(painter = icon, contentDescription = null, modifier = Modifier.size(16.dp))
            }
            SpacerHorizontal(width = 8.dp)
            Text(
                text = label,
                style = style,
                modifier = Modifier,
            )
        }

    }
}


@Composable
fun GradientButtonWithIcon1(
    gradientColors: List<Color> = listOf(
        buttonGradientColor1, buttonGradientColor2
    ),
    icon: Painter?,
    backgroundColor: Color = customPrimaryColor,
    style: TextStyle,
    label: String,
    height: Dp = 40.dp,
    borderWidth: Dp = 2.dp,
    modifier: Modifier,
    iconTint: Color,
    borderRadious: Dp = 6.dp,
    onClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(size = borderRadious))
            .border(
                width = borderWidth,
                brush = Brush.verticalGradient(colors = gradientColors),
                shape = RoundedCornerShape(size = borderRadious)
            )
            .background(backgroundColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onClick()
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Image(
                painter = icon,
                contentDescription = null,
                colorFilter = ColorFilter.tint(iconTint),
                modifier = Modifier.size(16.dp)
            )
            SpacerHorizontal(width = 8.dp)
        }
        Text(
            text = label,
            style = style,
        )
    }
}

@Composable
fun SimpleBorderWithTextButton(
    modifier: Modifier,
    height: Dp,
    bgColor: Color,
    borderRadious: Dp,
    borderColor: Color,
    text: String,
    onClick: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(6.dp))
            .border(
                color = borderColor,
                width = 1.dp,
                shape = RoundedCornerShape(borderRadious)
            )
            .background(bgColor)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = {
                    onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        NormalText(
            label = text,
            style = fontMedium.copy(color = customPrimaryColor)
        )
    }
}


@Composable
fun DeleteButtonWithIconTile(
    modifier: Modifier = Modifier,
    height: Dp = 40.dp,
    style: TextStyle = fontMedium.copy(
        color = colorBlack
    ),
    borderRadious: Dp = 6.dp,
    icon: Painter?,
    label: String, deleteItem: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(borderRadious))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { deleteItem() }
            )
            .background(commonBackground),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(colorBlack),
                    modifier = Modifier.size(16.dp)
                )
                SpacerHorizontal(width = 6.dp)
            }
            Text(
                text = label,
                style = style,
            )
        }
    }
}