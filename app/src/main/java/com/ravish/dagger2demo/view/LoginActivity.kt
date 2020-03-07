package com.ravish.dagger2demo.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.R
import com.ravish.dagger2demo.login.LoginComponent
import com.ravish.dagger2demo.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
     lateinit var loginViewModel: LoginViewModel

    lateinit var loginComponent: LoginComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent = (application as MyApplication).applicationComponent.loginComponent().create()
        loginComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        usernameEdit.setText(loginViewModel.loginManager.loggerUser)
        loginViewModel.navigateUserLiveData.observe(this, Observer {
            when (it) {
                MyApplication.USERNAVIGATION.HOME -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
                else -> {
                }
            }
            finish()
        })

        loginViewModel.errorRepsonseLiveData.observe(this, Observer {
            when (it) {
                LoginViewModel.ERRORMESSAGE.INVALIDUSER ->
                    Toast.makeText(
                        applicationContext,
                        "Username or Password is incorrect",
                        Toast.LENGTH_SHORT
                    ).show()
                else -> Toast.makeText(
                    applicationContext,
                    "User Not Registered",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        loginBtn.setOnClickListener {
            validateUser()
        }

        newUserTextView.setOnClickListener {
            val i = Intent(this, RegistrationActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT
            startActivity(i)
        }
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean, newConfig: Configuration?) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig)
        Log.e("Tag", "Is Multiwindow $isInMultiWindowMode")
    }

    private fun validateUser() {
        loginViewModel.validateUser(usernameEdit.text.toString(), passwordEdit.text.toString())
    }
}
