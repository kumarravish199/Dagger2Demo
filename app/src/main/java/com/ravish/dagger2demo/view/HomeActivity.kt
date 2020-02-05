package com.ravish.dagger2demo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.R
import com.ravish.dagger2demo.login.LoginManager
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var loginManager: LoginManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MyApplication).applicationComponent.inject(this)
        setContentView(R.layout.activity_home)
        userNameTextView.text = loginManager.loggerUser

        logOutBtn.setOnClickListener {
            loginManager.setUserLoggedin(false)
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }

    }
}
