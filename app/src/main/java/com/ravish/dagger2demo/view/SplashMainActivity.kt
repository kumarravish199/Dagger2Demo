package com.ravish.dagger2demo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ravish.dagger2demo.MyApplication
import com.ravish.dagger2demo.R
import com.ravish.dagger2demo.splash.SplashComponent
import com.ravish.dagger2demo.viewModel.SplashViewModel
import javax.inject.Inject

class SplashMainActivity : AppCompatActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel

    lateinit var splashComponent: SplashComponent
    override fun onCreate(savedInstanceState: Bundle?) {
       splashComponent =  (application as MyApplication).applicationComponent.splashComponenet().create()
        splashComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.sleep(2000)
        splashViewModel.navigateUserLiveData.observe(this, Observer {
            when(it) {
                MyApplication.USERNAVIGATION.LOGIN -> startActivity(Intent(this, LoginActivity::class.java))
                MyApplication.USERNAVIGATION.HOME -> startActivity(Intent(this, HomeActivity::class.java))
                else -> {}
            }
            finish()
        })
        splashViewModel.navigateUser()
    }
}
