package com.ravish.dagger2demo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.login.LoginManager
import com.ravish.dagger2demo.scope.ActivityScope
import com.ravish.dagger2demo.user.Storage
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(){

    @Inject
    lateinit var storage: Storage

    @Inject
    lateinit var loginManager: LoginManager

    enum class ERRORMESSAGE {
        INVALIDUSERNAME, INVALIDUSER
    }

    var navigateUserLiveData = MutableLiveData<MyApplication.USERNAVIGATION>()
    var errorRepsonseLiveData = MutableLiveData<ERRORMESSAGE>()


    fun validateUser(username:String, passWord:String) {

            if (storage.isValidUser(username, passWord)) {
                navigateUserLiveData.postValue(MyApplication.USERNAVIGATION.HOME)
                loginManager.setUserLoggedin(true)
                loginManager.loggerUser = username
            }
            else {
                errorRepsonseLiveData.postValue(ERRORMESSAGE.INVALIDUSER)
            }
        }
    }
