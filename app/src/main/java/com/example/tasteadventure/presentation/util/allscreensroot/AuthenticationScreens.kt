package com.example.tasteadventure.presentation.util.allscreensroot

import com.example.tasteadventure.presentation.util.ConstantAppScreenName

sealed class AuthenticationScreens(val route: String) {

//    object LoginScreen : AuthenticationScreens(ConstantAppScreenName.LOGIN_SCREEN)

    object SplashScreen : AuthenticationScreens(ConstantAppScreenName.SPLASH_SCREEN)
    object IntroScreen : AuthenticationScreens(ConstantAppScreenName.INTRO_SCREEN)

//    object ResetPasswordScreen :
//        AuthenticationScreens("${ConstantAppScreenName.RESET_PASSWORD_SCREEN}/{$ResetPasswordEmail}") {
//        fun getEmail(email: String): String {
//            return this.route.replace(
//                oldValue = "{${ResetPasswordEmail}}",
//                newValue = email
//            )
//        }
//    }

//    object RegisterScreen : AuthenticationScreens(ConstantAppScreenName.REGISTER_SCREEN)
//    object TermsAndConditionScreen :
//        AuthenticationScreens("${ConstantAppScreenName.TERMS_AND_CONDITION_SCREEN}/{$TermsConditionTitle}") {
//        fun getTitle(title: String): String {
//            return this.route.replace(
//                oldValue = "{$TermsConditionTitle}",
//                newValue = title
//            )
//        }
//    }

}