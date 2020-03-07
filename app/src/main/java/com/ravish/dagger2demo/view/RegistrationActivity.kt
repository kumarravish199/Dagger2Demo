package com.ravish.dagger2demo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.firebase.analytics.FirebaseAnalytics
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.R
import com.ravish.dagger2demo.registration.RegistrationComponent
import com.ravish.dagger2demo.viewModel.LoginViewModel
import com.ravish.dagger2demo.viewModel.RegistrationViewModel
import kotlinx.android.synthetic.main.activity_registration.*
import javax.inject.Inject

class RegistrationActivity : AppCompatActivity() {

    @Inject
    lateinit var registrationViewModel: RegistrationViewModel

    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    lateinit var registrationComponent: RegistrationComponent
    override fun onCreate(savedInstanceState: Bundle?) {
       registrationComponent = (application as MyApplication).applicationComponent.registrationComponent().create()
        registrationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        regBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "111")
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, usernameEdit.text.toString())
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "Image")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

            registrationViewModel.registerUser(usernameEdit.text.toString(), passwordEdit.text.toString())
        }

        registrationViewModel.errorRepsonseLiveData.observe(this, Observer {
            when (it) {
                LoginViewModel.ERRORMESSAGE.INVALIDUSERNAME ->
                    Toast.makeText(
                        applicationContext,
                        "Username already registered",
                        Toast.LENGTH_SHORT
                    ).show()
                else -> {}
            }
        })

        registrationViewModel.navigateUserLiveData.observe(this, Observer {
            when(it) {
                MyApplication.USERNAVIGATION.LOGIN -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    Toast.makeText(applicationContext, "User Registered", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        })
    }
}
