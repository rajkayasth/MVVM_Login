package com.example.loginmvvm.loginmodule.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.loginmvvm.R
import com.example.loginmvvm.databinding.ActivityLoginBinding
import com.example.loginmvvm.loginmodule.viewModels.LoginViewModel

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_login
        )

        val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.viewModel = viewModel

        binding.btnSubmit.setOnClickListener {
            viewModel.onLoginButtonClick()
            if (viewModel.password != null && viewModel.email != null){
                finishAffinity()
            }
        }


//        binding.btnSubmit.setOnClickListener {
//            binding.tvEmail.text = viewModel.tvEmail
//
//            binding.tvPassword.text = viewModel.tvPassword
//        }
    }
}