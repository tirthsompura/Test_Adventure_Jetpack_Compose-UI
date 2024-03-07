package com.example.tasteadventure.presentation.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tasteadventure.ui.theme.customPrimaryColor
import com.example.tasteadventure.ui.theme.indicatorActiveColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlin.math.abs

private const val MULTIPLIER_SELECTED_PAGE = 4
private val baseWidth = 4.dp
private val spacing = 10.dp
private val height = 5.dp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomPagerIndicatorSolution(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        val offsetIntPart = pagerState.currentPageOffset.toInt()
        val offsetFractionalPart = pagerState.currentPageOffset - offsetIntPart
        val currentPage = pagerState.currentPage + offsetIntPart
        val targetPage = if (pagerState.currentPageOffset < 0) currentPage - 1 else currentPage + 1
        val currentPageWidth =
            baseWidth * (1 + (1 - abs(offsetFractionalPart)) * MULTIPLIER_SELECTED_PAGE)
        val targetPageWidth = baseWidth * (1 + abs(offsetFractionalPart) * MULTIPLIER_SELECTED_PAGE)

        repeat(pagerState.pageCount) { index ->
            val width = when (index) {
                currentPage -> currentPageWidth
                targetPage -> targetPageWidth
                else -> baseWidth
            }
            val color = when (index) {
                currentPage -> indicatorActiveColor
                targetPage -> Color.Gray
                else -> Color.Gray
            }
            val shape = when (index) {
                currentPage -> RoundedCornerShape(4.dp, 4.dp, 4.dp, 4.dp)
                targetPage -> RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp)
                else -> RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp)
            }
            Box(
                modifier = modifier
                    .width(animateDpAsState(targetValue = width).value)
                    .width(width)
                    .clip(shape = shape)
                    .background(color)
                    .height(height)
            )
            if (index != pagerState.pageCount - 1) {
                Spacer(modifier = Modifier.width(spacing))
            }
        }
    }
}
