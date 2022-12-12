package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnLogin2.setOnClickListener {
            startLogin()
        }
    }


    private fun startLogin() {

        val username = binding.username.text.toString()
        val password = binding.password.text.toString()

        val user: User? = sharedPreferenceUtil.getUser()

        if (username == user?.username && password == user.password) {
            startActivity(Intent(this, MainActivity::class.java))

        } else {

            Toast.makeText(this, "Error usuario", Toast.LENGTH_SHORT).show()
        }
    }

}