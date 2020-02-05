package com.ravish.dagger2demo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.login.LoginManager
import com.ravish.dagger2demo.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class SplashViewModel @Inject constructor(){

   var navigateUserLiveData = MutableLiveData<MyApplication.USERNAVIGATION>()

    @Inject
     lateinit var loginManager:LoginManager

    fun navigateUser() {
        when(loginManager.isUserLoggedin()!!) {
            true -> navigateUserLiveData.postValue(MyApplication.USERNAVIGATION.HOME)
            else ->  navigateUserLiveData.postValue(MyApplication.USERNAVIGATION.LOGIN)
        }
    }
}