package com.example.tasteadventure.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tasteadventure.presentation.chat.ChatUserListScreen
import com.example.tasteadventure.presentation.friends.LocationScreen
import com.example.tasteadventure.presentation.home.HomeScreen
import com.example.tasteadventure.presentation.profile.MyProfileScreen
import com.example.tasteadventure.presentation.util.ConstantAppScreenName.NOTIFICATION_ROUTE
import com.example.tasteadventure.presentation.util.ConstantAppScreenName.LOCATION_ROUTE
import com.example.tasteadventure.presentation.util.ConstantAppScreenName.HOME_ROUTE
import com.example.tasteadventure.presentation.util.ConstantAppScreenName.PROFILE_ROUTE
import com.example.tasteadventure.util.RootGraph
import com.example.tasteadventure.util.SessionManagerClass


@Composable
fun DashboardNavigationGraph(navController: NavHostController,sessionManagerClass: SessionManagerClass) {
    NavHost(
        navController = navController,
        route =  RootGraph.DASHBOARD,
        startDestination = HOME_ROUTE

    ){
        composable(route = HOME_ROUTE) {
            HomeScreen(navController,sessionManagerClass)
        }
        composable(route =LOCATION_ROUTE) {
            LocationScreen(navController)
        }
        composable(route = NOTIFICATION_ROUTE) {
            ChatUserListScreen(navController)
        }
        composable(route =PROFILE_ROUTE) {
            MyProfileScreen(navController)
        }
//        friendsNavigationGraph(navController)
//        homeDetailNavigationGraph(navController)
//        chatNavigationGraph(navController)
        profileNavigationGraph(navController)
        authenticationNavigationGraph(navController)
    }
}