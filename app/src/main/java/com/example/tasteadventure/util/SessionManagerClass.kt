package com.example.tasteadventure.util

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import com.example.tasteadventure.domain.model.UserResponse


@Singleton
class SessionManagerClass @Inject constructor(@ApplicationContext context: Context) {

    var showNoInternetDialog  = mutableStateOf(false)
//    var buyerNotificationCount  = mutableStateOf(0)
//    var sellerNotificationCount  = mutableStateOf(0)
    private var prefs: SharedPreferences? = null

    var isGuestUser:Boolean=false
    var lastGuestUserRoute:String=""

    //    var totalCartCount :String =""
    init {
        prefs =
            context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)
    }

    var isLogin: Boolean
        get() {
            return prefs!!.getBoolean(PrefKey.IS_LOGIN, false)
        }
        set(value) {
            prefs!!.edit().putBoolean(PrefKey.IS_LOGIN, value).apply()
        }


    var loginUserData: UserResponse?
        get() {
            return if (prefs!!.getString(PrefKey.Login_user_response, "")?.isNotEmpty() == true){
                val userResponse: UserResponse? =
                    prefs!!.getString(PrefKey.Login_user_response, "")?.fromPrettyJson()
                userResponse
            }else
                null

        }
        set(value) {
            prefs!!.edit().putString(PrefKey.Login_user_response, value?.toPrettyJson()).apply()
        }

    fun clearSessionData() {
        prefs?.edit()?.clear()?.apply()
    }
}

object PrefKey {
    const val IS_LOGIN = "is_login"
    const val Login_user_response = "Login_user_response"
}