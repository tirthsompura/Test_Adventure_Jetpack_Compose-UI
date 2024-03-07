package com.example.tasteadventure.presentation.splashscreen

import android.app.Activity
import android.os.Build.VERSION.SDK_INT
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.tasteadventure.R
import com.example.tasteadventure.presentation.component.ChangeStatusBarColor
import com.example.tasteadventure.presentation.util.allscreensroot.AuthenticationScreens
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.util.RootGraph

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel(),
    ) {
    val scale = remember {
        Animatable(0f)
    }
    val context = LocalContext.current as Activity

    WindowCompat.setDecorFitsSystemWindows(context.window, false)
    ChangeStatusBarColor(Color.Transparent, navBarColor = Color.Transparent)

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.0f,
            animationSpec = tween(
                durationMillis = 4000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                })
        )
//        delay(2000L)
        //Save data to session
        if (splashScreenViewModel.sessionManagerClass.isLogin) {
            navController.navigate(RootGraph.DASHBOARD) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(AuthenticationScreens.IntroScreen.route) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_spalash_bg),
//            contentDescription = "",
//            modifier = Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop
//        )
        Box(modifier = Modifier.fillMaxSize().background(bgColor), contentAlignment = Alignment.Center) {
            GifImage()
        }
    }
}


@Composable
fun GifImage(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.ic_splash_gif2).apply(block = {
                size(Size.ORIGINAL)
            }
            ).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
    )
}