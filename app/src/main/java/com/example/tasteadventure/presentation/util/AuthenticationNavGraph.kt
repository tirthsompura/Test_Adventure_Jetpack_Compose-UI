package com.example.tasteadventure.presentation.util

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.tasteadventure.presentation.intro.IntroScreen
import com.example.tasteadventure.presentation.splashscreen.SplashScreen
import com.example.tasteadventure.presentation.util.allscreensroot.AuthenticationScreens
import com.example.tasteadventure.util.RootGraph


fun NavGraphBuilder.authenticationNavigationGraph(navController: NavHostController) {
    navigation(
        route = RootGraph.AUTHENTICATION,
        startDestination = AuthenticationScreens.SplashScreen.route
    ) {
//        composable(
//            route = AuthenticationScreens.LoginScreen.route,
//        ) {
//            LoginScreen(navController)
//        }
        composable(route = AuthenticationScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = AuthenticationScreens.IntroScreen.route) {
            IntroScreen(
                navController = navController
            )
        }

//        composable(route = AuthenticationScreens.RegisterScreen.route) {
//            RegisterScreen(
//                navController = navController
//            )
//        }

//        composable(
//            route = AuthenticationScreens.ResetPasswordScreen.route,
//            arguments = listOf(navArgument(NavigationConstants.ResetPasswordEmail) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val email = it.arguments?.getString(NavigationConstants.ResetPasswordEmail)
//            ResetPasswordScreen(navController, email = email.toString())
//        }

//        composable(
//            route = AuthenticationScreens.TermsAndConditionScreen.route,
//            arguments = listOf(navArgument(NavigationConstants.TermsConditionTitle) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val title = it.arguments?.getString(NavigationConstants.TermsConditionTitle)
//            TermsAndConditionScreen(navController, title = title.toString())
//        }
    }
}