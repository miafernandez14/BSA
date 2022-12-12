package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)

        binding.btnLogin.setOnClickListener {
            startLogin()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Ingrese los datos del usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this, "Error usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccessActivity.observe(this){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun startLogin() {
        loginViewModel.validateInputs(
            binding.username.text.toString(),
            binding.password.text.toString()
        )
    }

}