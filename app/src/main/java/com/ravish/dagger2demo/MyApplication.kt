package com.ravish.dagger2demo

import android.app.Application
import com.ravish.dagger2demo.di.ApplicationComponent
import com.ravish.dagger2demo.di.DaggerApplicationComponent

class MyApplication: Application() {
    enum class USERNAVIGATION {
        HOME, LOGIN, REGISTRAION
    }
    val applicationComponent:ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}