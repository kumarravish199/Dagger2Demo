package com.ravish.dagger2demo.fcm

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides

@Module
class FireBaseModule {

    @Provides
    fun getFireBaseAnalaytics(context: Context):FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }
}