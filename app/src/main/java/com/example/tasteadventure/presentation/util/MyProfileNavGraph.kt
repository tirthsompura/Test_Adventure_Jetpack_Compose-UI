package com.example.tasteadventure.presentation.util

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tasteadventure.presentation.cart.CartScreen
import com.example.tasteadventure.presentation.payment.PaymentScreen
import com.example.tasteadventure.presentation.util.allscreensroot.MyProfileScreens
import com.example.tasteadventure.util.RootGraph


fun NavGraphBuilder.profileNavigationGraph(navController: NavHostController) {
    navigation(
        route = RootGraph.PROFILE_DETAIL,
        startDestination = MyProfileScreens.CartScreenScreen.route
    ) {
        composable(
            route = MyProfileScreens.CartScreenScreen.route,
        ) {
            CartScreen(navController)
        }
        composable(
            route = MyProfileScreens.PaymentScreen.route,
        ) {
            PaymentScreen(navController)
        }
//        composable(
//            route = MyProfileScreens.FavoriteEventScreen.route,
//        ) {
//            FavouriteEventScreen(navController)
//        }
//        composable(
//            route = MyProfileScreens.EditProfileScreen.route,
//            arguments = listOf(navArgument(ValidationConstants.myProfile) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val myProfileData = it.arguments?.getString(ValidationConstants.myProfile)
//            EditProfileScreen(navController, myProfileDataJson = myProfileData)
//        }
//        composable(
//            route = MyProfileScreens.ChangeLanguageScreen.route,
//        ) {
//            ChangeLanguageScreen(navController)
//        }

//        composable(
//            route = MyProfileScreens.CloseFriendScreen.route,
//        ) {
//            CloseFriendsScreen(navController)
//        }

//        composable(
//            route = MyProfileScreens.ChangePasswordScreen.route,
//        ) {
//            ChangePasswordScreen(navController)
//        }

//        composable(
//            route = MyProfileScreens.MyEventsJoinedScreen.route,
//            arguments = listOf(navArgument(ValidationConstants.userID) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val sendIdsDataString = it.arguments?.getString(ValidationConstants.userID)
//            MyEventsJoinedScreen(navController, userIdsDataString = sendIdsDataString.toString())
//        }


//        composable(
//            route = MyProfileScreens.EventTypeScreen.route,
//            arguments = listOf(navArgument(ValidationConstants.EventScreenType) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val eventScreenType = it.arguments?.getString(ValidationConstants.EventScreenType)
//            EventTypeScreen(navController, eventScreenType = eventScreenType.toString())
//        }

//        composable(
//            route = MyProfileScreens.BlockRemoveUserScreen.route,
//            arguments = listOf(navArgument(ValidationConstants.BlockRemoveUserScreenType) {
//                type = NavType.StringType
//                defaultValue = ""
//            })
//        ) {
//            val blockRemoveUserScreenType = it.arguments?.getString(ValidationConstants.BlockRemoveUserScreenType)
//            BlockRemoveUserScreen(navController, blockRemoveUserScreenType = blockRemoveUserScreenType.toString())
//        }
    }
}