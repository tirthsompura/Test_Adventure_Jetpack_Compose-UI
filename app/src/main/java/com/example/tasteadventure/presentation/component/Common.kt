package com.example.tasteadventure.presentation.component

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.ui.theme.fontRegular
import com.example.tasteadventure.ui.theme.redColor
import com.example.tasteadventure.ui.theme.whiteColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun ChangeStatusBarColor(color: Color = bgColor, navBarColor :Color = Color.White) {
    val systemUiController = rememberSystemUiController()
    val darkTheme = isSystemInDarkTheme()
    ///TODO : Pending
    SideEffect {

        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = true
        )
        systemUiController.setNavigationBarColor(
            color = navBarColor,
            darkIcons = true
        )
    }
}

@Composable
fun LoadCommonIcon(icon: Int, iconClick: () -> Unit) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Image(
        modifier = Modifier
            .size(24.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { iconClick() }),
        painter = painterResource(id = icon),
        contentDescription = ""
    )
}

@Composable
fun CountDownTimer(
    labelText:String,    // color of inactive bar / progress bar
    inactiveBarColor: Color,

    // color of active bar
    activeBarColor: Color,
    modifier: Modifier = Modifier,

    // set initial value to 1
    initialValue: Float = 1f,
    strokeWidth: Dp = 2.dp,
    percentage :String ="0"
) {
    // create variable for
    // size of the composable
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    // create variable for value
    var value by remember {
        mutableStateOf(initialValue)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(Color.Blue)
            .onSizeChanged {
                size = it
            }
    ) {
        // draw the timer
        Canvas(modifier = modifier) {
                drawArc(
                    color = inactiveBarColor, // assign the color
                    startAngle = 0f, // assign the start angle
                    sweepAngle = 270f, // arc angles
                    useCenter = false, // prevents our arc to connect at te ends
                    size = Size(size.width.toFloat(), size.height.toFloat()),

                    // to make ends of arc round
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = activeBarColor, // assign the color
                    startAngle = 180f,  // assign the start angle
                    sweepAngle = ((percentage.toInt() * 360) / 100).toFloat(), // reduce the sweep angle
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
        }
        // add value of the timer
            NormalText(
                label = labelText,
                style = fontRegular.copy(
                    color = redColor,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                ),
                modifier = Modifier.rotate(-50f)
            )


    }
}

//Countdown Timer
@Composable
fun CountDown(
    // total time of the timer
    totalTime: Long,
    // color of inactive bar / progress bar
    inactiveBarColor: Color,

    // color of active bar
    activeBarColor: Color,
    modifier: Modifier = Modifier,

    // set initial value to 1
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    // create variable for
    // size of the composable
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    // create variable for value
    var value by remember {
        mutableStateOf(initialValue)
    }
    // create variable for current time
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    // create variable for isTimerRunning
    var isTimerRunning by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        // draw the timer
        Canvas(modifier = modifier) {
            if (currentTime / 1000L != 0L) {
                drawArc(
                    color = inactiveBarColor, // assign the color
                    startAngle = 0f, // assign the start angle
                    sweepAngle = 270f, // arc angles
                    useCenter = false, // prevents our arc to connect at te ends
                    size = Size(size.width.toFloat(), size.height.toFloat()),

                    // to make ends of arc round
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = activeBarColor, // assign the color
                    startAngle = 180f,  // assign the start angle
                    sweepAngle = (270f * value*1.3).toFloat(), // reduce the sweep angle
                    useCenter = false,
                    size = Size(size.width.toFloat(), size.height.toFloat()),
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
        }
        // add value of the timer
        if (currentTime / 1000L != 0L) {
            NormalText(
                label = "${(currentTime / 1000L)}d",
                style = fontRegular.copy(
                    color = redColor,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                ),
                modifier = Modifier.rotate(-50f)
            )
        }
    }
}

@Composable
fun drawBottomSheetLine(bgColor: Color = bottomBarBGColor) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .height(5.dp)
                .width(50.dp)
                .clip(shape = CircleShape)
                .background(bgColor)
        ) {
        }
    }
}
