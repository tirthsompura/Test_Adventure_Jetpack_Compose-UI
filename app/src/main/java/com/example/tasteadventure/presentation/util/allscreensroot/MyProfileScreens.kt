package com.example.tasteadventure.presentation.util.allscreensroot

import com.example.tasteadventure.presentation.util.ConstantAppScreenName

sealed class MyProfileScreens(val route: String) {
    object CartScreenScreen : MyProfileScreens(ConstantAppScreenName.CART_SCREEN)
    object PaymentScreen : MyProfileScreens(ConstantAppScreenName.PAYMENT_SCREEN)
//    object EditProfileScreen :
//        MyProfileScreens("${ConstantAppScreenName.EDIT_PROFILE_SCREEN}/{${ValidationConstants.myProfile}}"){
//            fun myProfileData(profileData: String): String{
//                return this.route.replace(
//                    oldValue = "{${ValidationConstants.myProfile}}",
//                    newValue = profileData
//                )
//            }
//        }
//
//    object ChangeLanguageScreen : MyProfileScreens(ConstantAppScreenName.CHANGE_LANGUAGE_SCREEN)
//    object CloseFriendScreen : MyProfileScreens(ConstantAppScreenName.CLOSE_FRIENDS_SCREEN)
//    object ChangePasswordScreen : MyProfileScreens(ConstantAppScreenName.CHANGE_PASSWORD_SCREEN)
//    object MyEventsJoinedScreen :
//        MyProfileScreens("${ConstantAppScreenName.MY_EVENTS_JOINED_SCREEN}/{${ValidationConstants.userID}}") {
//        fun eventJoinScreenEncodedString(eventScreenType: String): String {
//            return this.route.replace(
//                oldValue = "{${ValidationConstants.userID}}",
//                newValue = eventScreenType
//            )
//        }
//    }
//
//    object EventTypeScreen : MyProfileScreens("${ConstantAppScreenName.EVENT_TYPE_SCREEN}/{${ValidationConstants.EventScreenType}}") {
//        fun eventScreenType(eventScreenType: String): String {
//            return this.route.replace(
//                oldValue = "{${ValidationConstants.EventScreenType}}",
//                newValue = eventScreenType
//            )
//        }
//    }
//
//    object BlockRemoveUserScreen :
//        MyProfileScreens("${ConstantAppScreenName.BLOCK_REMOVE_USER_SCREEN}/{${ValidationConstants.BlockRemoveUserScreenType}}") {
//        fun blockRemoveUserScreenType(blockRemoveUserScreenType: String): String {
//            return this.route.replace(
//                oldValue = "{${ValidationConstants.BlockRemoveUserScreenType}}",
//                newValue = blockRemoveUserScreenType
//            )
//        }
//    }
}