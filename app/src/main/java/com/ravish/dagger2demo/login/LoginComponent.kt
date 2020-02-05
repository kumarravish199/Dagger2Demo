package com.ravish.dagger2demo.login

import com.ravish.dagger2demo.scope.ActivityScope
import com.ravish.dagger2demo.view.LoginActivity
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create():LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
}