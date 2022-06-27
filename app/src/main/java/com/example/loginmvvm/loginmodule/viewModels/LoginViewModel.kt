package com.example.loginmvvm.loginmodule.viewModels

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.loginmvvm.homeModule.HomeActivity

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPrefFile = "pref_key"
    var email : String? = null
    var password : String? = null

    var tvEmail : String? = null
    var tvPassword : String? = null

    val sharedPreferences: SharedPreferences = getApplication<Application>().getSharedPreferences(sharedPrefFile,
        Context.MODE_PRIVATE)


    fun OpenActivity(context: Context){
        val intent = Intent(getApplication(), HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
        val editor:SharedPreferences.Editor =  sharedPreferences.edit()
        val name = email
        val password = password

        editor.putString("name",name)
        editor.putString("password",password)
        editor.putBoolean("isLogin",true)

        editor.apply()
        editor.commit()

    }

    @SuppressLint("CommitPrefEdits")
    fun onLoginButtonClick(){
        if (email ==null ){
            Toast.makeText(getApplication(), "Email or password is null", Toast.LENGTH_SHORT).show()
        }else{
            Log.d("TAG","Email $email or password is $password")
            Toast.makeText(getApplication(), "Email $email or password is $password", Toast.LENGTH_SHORT).show()
            OpenActivity(getApplication())

        }
    }
}