package com.ravish.dagger2demo.di

import android.content.Context
import com.ravish.dagger2demo.fcm.FireBaseModule
import com.ravish.dagger2demo.login.LoginComponent
import com.ravish.dagger2demo.registration.RegistrationComponent
import com.ravish.dagger2demo.splash.SplashComponent
import com.ravish.dagger2demo.user.StorageModule
import com.ravish.dagger2demo.view.HomeActivity
import com.ravish.dagger2demo.viewModel.LoginViewModel
import com.ravish.dagger2demo.viewModel.SplashViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubComponent::class, FireBaseModule::class])
 interface ApplicationComponent {

 @Component.Factory
 interface Factory {
  fun create(@BindsInstance context:Context): ApplicationComponent
 }


 fun inject(homeActivity: HomeActivity)

 fun registrationComponent():RegistrationComponent.Factory
 fun loginComponent():LoginComponent.Factory
 fun splashComponenet():SplashComponent.Factory
}