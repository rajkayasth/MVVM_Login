package com.example.loginmvvm.splashmodule

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.loginmvvm.R
import com.example.loginmvvm.homeModule.HomeActivity
import com.example.loginmvvm.loginmodule.ui.LoginActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val sharedPrefFile = "pref_key"
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)
       // val sharedpassValue = sharedPreferences.getBoolean("isLogin",false)



        handler.postDelayed({
            //Log.d("ISLOGIN___>",sharedpassValue.toString())
            if (getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE).getBoolean("isLogin", false)) {
                val i = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(this@SplashActivity, LoginActivity::class.java)

                startActivity(i)
                finish()
            }
        }, 2000)
    }

    override fun onBackPressed() {
        finishAndRemoveTask()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacksAndMessages(null)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        handler.removeCallbacksAndMessages(null)
//    }
}