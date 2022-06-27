package com.example.loginmvvm.homeModule

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.loginmvvm.R
import com.example.loginmvvm.loginmodule.ui.LoginActivity

class HomeActivity : AppCompatActivity() {
    private val sharedPrefFile = "pref_key"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txtview : TextView = findViewById(R.id.txtHome)
        val txtPassword : TextView = findViewById(R.id.txtPassword)
        val btnClear = findViewById<Button>(R.id.btnClear)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        val sharedNameValue = sharedPreferences.getString("name","defaultname")
        val sharedpassValue = sharedPreferences.getBoolean("isLogin",false)

        txtview.text = sharedNameValue
        txtPassword.text = sharedpassValue.toString()

        btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }


    }

    override fun onBackPressed() {
        finishAffinity()
    }

}