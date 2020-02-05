package com.ravish.dagger2demo.registration

import com.ravish.dagger2demo.scope.ActivityScope
import com.ravish.dagger2demo.view.RegistrationActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create():RegistrationComponent
    }

    fun inject(registrationActivity: RegistrationActivity)
}