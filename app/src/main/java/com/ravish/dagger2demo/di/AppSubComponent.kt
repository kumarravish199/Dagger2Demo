package com.ravish.dagger2demo.di

import com.ravish.dagger2demo.login.LoginComponent
import com.ravish.dagger2demo.registration.RegistrationComponent
import com.ravish.dagger2demo.splash.SplashComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, SplashComponent::class])
class AppSubComponent {
}