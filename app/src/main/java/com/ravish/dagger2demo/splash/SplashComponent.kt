package com.ravish.dagger2demo.splash

import com.ravish.dagger2demo.scope.ActivityScope
import com.ravish.dagger2demo.view.SplashMainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun inject(splashMainActivity: SplashMainActivity)
}