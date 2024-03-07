package com.example.tasteadventure.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tasteadventure.App
import com.example.tasteadventure.presentation.dashboard.DashBoardScreen
import com.example.tasteadventure.util.RootGraph
import com.example.tasteadventure.util.SessionManagerClass

@Composable
fun RootNavGraph(sessionManagerClass: SessionManagerClass) {
    val navController = rememberNavController()
    App.navHostController = navController
    App.context = LocalContext.current
    NavHost(
        navController = navController,
        route = RootGraph.ROOT,
        startDestination = RootGraph.DASHBOARD,
    ) {
        authenticationNavigationGraph(navController = navController)
        composable(route = RootGraph.DASHBOARD) {
            DashBoardScreen(sessionManagerClass)
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}