package com.ravish.dagger2demo.login

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginManager @Inject constructor(val context: Context?) {
   private val loginPref = "loginPref"
   private val userLoggedIn = "userLoggedIn"
   private val sharePref = context?.getSharedPreferences(loginPref, Context.MODE_PRIVATE)
    var loggerUser:String? = null
    fun isUserLoggedin(): Boolean?{
        return sharePref?.getBoolean(userLoggedIn, false)
    }

    fun setUserLoggedin(flag:Boolean){
        val sharePref = context?.getSharedPreferences(loginPref, Context.MODE_PRIVATE)
        with(sharePref?.edit()) {
            this?.putBoolean(userLoggedIn, flag)
            this?.commit()
        }
    }
}