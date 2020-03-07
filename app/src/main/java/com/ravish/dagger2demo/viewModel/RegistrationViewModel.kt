package com.ravish.dagger2demo.viewModel

import androidx.lifecycle.MutableLiveData
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.login.LoginManager
import com.ravish.dagger2demo.scope.ActivityScope
import com.ravish.dagger2demo.user.Storage
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@ActivityScope
class RegistrationViewModel @Inject constructor(){

    @Inject
    lateinit var storage: Storage

    @Inject
    lateinit var loginManager: LoginManager

    var navigateUserLiveData = MutableLiveData<MyApplication.USERNAVIGATION>()
    var errorRepsonseLiveData = MutableLiveData<LoginViewModel.ERRORMESSAGE>()

    fun registerUser(username: String, passWord: String) {
        if(validateUserName(username)) {
            errorRepsonseLiveData.postValue(LoginViewModel.ERRORMESSAGE.INVALIDUSERNAME)
        }
        else {
            storage.setUserinfo(username, passWord)
            loginManager.loggerUser = username
            navigateUserLiveData.postValue(MyApplication.USERNAVIGATION.LOGIN)
        }
    }

    private fun validateUserName(username: String):Boolean {
        return storage.isUserRegistered(username)
    }


}