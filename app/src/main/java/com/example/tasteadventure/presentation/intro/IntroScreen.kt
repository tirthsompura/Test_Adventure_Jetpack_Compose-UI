package com.example.tasteadventure.presentation.intro

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.IntroPageDataClass
import com.example.tasteadventure.presentation.component.ChangeStatusBarColor
import com.example.tasteadventure.presentation.component.CustomPagerIndicatorSolution
import com.example.tasteadventure.presentation.component.GradientButton
import com.example.tasteadventure.presentation.component.SpacerVertical
import com.example.tasteadventure.presentation.util.NormalText
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.fontMedium
import com.example.tasteadventure.ui.theme.fontSemiBold
import com.example.tasteadventure.ui.theme.indicatorActiveColor
import com.example.tasteadventure.ui.theme.whiteColor
import com.example.tasteadventure.util.RootGraph
import com.example.tasteadventure.util.getDensity
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IntroScreen(
    navController: NavController, viewModel: IntroScreenViewModel = hiltViewModel(),
) {

    val context = LocalContext.current as Activity
    WindowCompat.setDecorFitsSystemWindows(context.window, false)
    ChangeStatusBarColor(Color.Transparent, navBarColor = Color.Transparent)

    val introPageDataClassList = viewModel.getIntroPageDataClassList()
    CompositionLocalProvider(
        LocalDensity provides getDensity(),
    ) {
        Scaffold {
            IntroPageBody(navController, context, introPageDataClassList)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroPageBody(
    navHostController: NavController,
    context: Context,
    introPageDataClassList: ArrayList<IntroPageDataClass>,
) {
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = introPageDataClassList.size,
            state = pagerState,
        ) { pageIndex ->
            Box {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(bgColor)
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .padding(top = 150.dp)
                                    .fillMaxWidth()
                                    .height(300.dp)
                                    .background(
                                        bgColor
                                    ), contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = introPageDataClassList[pageIndex].imageId),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillBounds,
                                    alignment = Alignment.Center
                                )
                            }
                            SpacerVertical(height = 80.dp)
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 20.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                NormalText(
                                    label = introPageDataClassList[pageIndex].label,
                                    style = fontSemiBold.copy(color = indicatorActiveColor)
                                )
                                SpacerVertical(height = 15.dp)
                                NormalText(
                                    label = introPageDataClassList[pageIndex].description,
                                    style = fontMedium.copy(color = indicatorActiveColor),
                                    maxLine = 5,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SkipComponent(pagerState, navHostController, context)

            BottomComponent(pagerState, introPageDataClassList, navHostController)
        }

    }
}

//fun navigateToLogin(navController: NavController) {
//    navController.navigate(AuthenticationScreens.LoginScreen.route) {
//        popUpTo(navController.graph.id) {
//            inclusive = true
//        }
//    }
//}
fun navigateToHomePage(navController: NavController) {
    navController.navigate(RootGraph.DASHBOARD) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomComponent(
    pagerState: PagerState,
    introPageDataClassList: ArrayList<IntroPageDataClass>,
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 30.dp)
                .height(62.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.weight(2f))
            val coroutineScope = rememberCoroutineScope()

            if (pagerState.currentPage == pagerState.pageCount - 1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 90.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    GradientButton(
                        label = stringResource(id = R.string.lets_get_cooking),
                        style = fontSemiBold.copy(
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            color = whiteColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        borderRadious = 100.dp
                    ) {

//                        navigateToLogin(navController = navController)
                        navigateToHomePage(navController = navController)
                    }
                }
            } else {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 110.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    GradientButton(
                        label = stringResource(id = R.string.skip),
                        style = fontSemiBold.copy(
                            fontSize = 18.sp,
                            lineHeight = 24.sp,
                            color = whiteColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth(),
                        borderRadious = 100.dp
                    ) {
                        coroutineScope.launch {
                            // Call scroll to on pagerState
                            if (pagerState.currentPage == pagerState.pageCount - 1) {
//                                        navigateToLogin(navController = navController)
                            } else {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipComponent(pagerState: PagerState, navController: NavController, context: Context) {
    /// Skip text
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val coroutineScope = rememberCoroutineScope()
    if (pagerState.currentPage != pagerState.pageCount - 1) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
//                        coroutineScope.launch {
//                            navigateToLogin(navController = navController)
//                        }
                    }
                ),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .offset(y = 20.dp)
                    .background(bgColor, shape = RoundedCornerShape(56.dp))
                    .padding(8.dp)
            ) {
                CustomPagerIndicatorSolution(
                    pagerState = pagerState,
                )
            }
        }
    } else {
        Box(modifier = Modifier)
    }
}
