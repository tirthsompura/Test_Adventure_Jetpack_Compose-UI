package com.example.tasteadventure.presentation.dashboard

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tasteadventure.R
import com.example.tasteadventure.domain.model.BottomBarNavigationModel
import com.example.tasteadventure.presentation.component.LoadCommonIcon
import com.example.tasteadventure.presentation.util.ConstantAppScreenName
import com.example.tasteadventure.presentation.util.DashboardNavigationGraph
import com.example.tasteadventure.presentation.util.currentRoute
import com.example.tasteadventure.presentation.util.keyboardVisibility
import com.example.tasteadventure.ui.theme.bgColor
import com.example.tasteadventure.ui.theme.bottomBarBGColor
import com.example.tasteadventure.util.SessionManagerClass

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashBoardScreen(sessionManagerClass: SessionManagerClass) {
    val navController: NavHostController = rememberNavController()
    var isKeyboardOpen by remember { mutableStateOf(false) }
    keyboardVisibility().observeForever {
        isKeyboardOpen = it
    }
    Scaffold(
        backgroundColor = bgColor,
        bottomBar = {
            AnimatedVisibility(
                visible = !isKeyboardOpen,
                enter = slideInVertically(
                    initialOffsetY = {
                        it / 3
                    },
                ),
                exit = slideOutVertically(
                    targetOffsetY = {
                        (it / 0.5).toInt()
                    },
                ),
            ) {
                DashBoardBottomBar(navController)
            }
        }, content = {
            DashboardNavigationGraph(navController, sessionManagerClass)
        }
    )
}

@Composable
fun DashBoardBottomBar(navController: NavHostController) {

    val screens = ArrayList<BottomBarNavigationModel>()
    screens.add(
        BottomBarNavigationModel(
            route = ConstantAppScreenName.HOME_ROUTE,
            name = stringResource(R.string.home),
            icon = R.drawable.ic_home,
            icon_focused = R.drawable.ic_home_fill
        )
    )
    screens.add(
        BottomBarNavigationModel(
            route = ConstantAppScreenName.LOCATION_ROUTE,
            name = stringResource(R.string.location),
            icon = R.drawable.ic_location,
            icon_focused = R.drawable.ic_location_fill
        )
    )
    screens.add(
        BottomBarNavigationModel(
            route = ConstantAppScreenName.PROFILE_ROUTE,
            name = stringResource(R.string.profile),
            icon = R.drawable.ic_circle,
            icon_focused = R.drawable.ic_circle_fill
        )
    )
    screens.add(
        BottomBarNavigationModel(
            route = ConstantAppScreenName.NOTIFICATION_ROUTE,
            name = stringResource(R.string.notification),
            icon = R.drawable.ic_notification,
            icon_focused = R.drawable.ic_notification_fill
        )
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    val interactionSource = remember {
        MutableInteractionSource()
    }

    // To hide bottom bar
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        val currentRoute = currentRoute(navController)
        Row(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
                .height(70.dp)
                .clip(shape = RoundedCornerShape(100.dp))
                .background(bottomBarBGColor)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { item ->
                val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                val icon = if (selected) item.icon_focused else item.icon
                Column(
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                callRoute(navController, currentRoute.toString(), item.route)
                            }
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Box(modifier = Modifier) {
                        LoadCommonIcon(icon) {
                            callRoute(navController, currentRoute.toString(), item.route)
                        }
                    }
                }
            }
        }
    }
}


fun callRoute(navController: NavHostController, currentRoute: String, itemRoute: String) {
    if (currentRoute != itemRoute) {
        navController.navigate(itemRoute) {
            popUpTo(navController.graph.findStartDestination().id)
            launchSingleTop = true
        }
    }
}