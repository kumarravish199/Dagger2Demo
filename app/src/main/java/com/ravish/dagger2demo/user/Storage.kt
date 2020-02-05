package com.ravish.dagger2demo.user

interface Storage {
    fun setUserinfo(username: String, password: String)
    fun isUserRegistered(username:String): Boolean
    fun isValidUser(username:String, password:String): Boolean
}