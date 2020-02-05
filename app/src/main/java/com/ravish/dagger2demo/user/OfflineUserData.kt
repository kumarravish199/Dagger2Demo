package com.ravish.dagger2demo.user

import android.content.Context
import javax.inject.Inject

class OfflineUserData @Inject constructor(context: Context) : Storage {
    val sharePref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    override fun setUserinfo(username: String, password: String) {
        val editor = sharePref.edit()
        editor.putString(username, username)
        editor.putString("${username}Password", password)
        editor.apply()
    }

    override fun isUserRegistered(username: String): Boolean {
        return getUsername(username)?.isNotEmpty()!!
    }

    override fun isValidUser(username: String, password: String): Boolean {
        return getUsername(username)?.isNotEmpty()!! && getPassword(username).equals(password)
    }

    private fun getUsername(username: String): String? {
        return sharePref.getString(username, "")
    }

    private fun getPassword(username: String): String? {
        return sharePref.getString("${username}Password", "")
    }
}