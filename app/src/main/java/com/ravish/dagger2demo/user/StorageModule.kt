package com.ravish.dagger2demo.user

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import javax.inject.Inject

@Module
abstract class StorageModule{
    @Binds
  abstract fun getUserManagerData(offlineUserData: OfflineUserData): Storage
}