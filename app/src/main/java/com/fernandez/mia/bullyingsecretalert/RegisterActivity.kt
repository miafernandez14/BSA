package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnRegister.setOnClickListener {
            val userId = "1"
            val name = binding.name.text.toString()
            val last_name = binding.lastname.text.toString()
            val email = binding.email.text.toString()
            val sexo = binding.sexo.text.toString()
            val username = binding.username.toString()
            val password = binding.password.toString()

            val user=User(
                userId,
                name,
                last_name,
                email,
                sexo,
                username,
                password
            )
            sharedPreferenceUtil.saveUser(user)

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    fun login(view: View) {
        startActivity(Intent(this,LoginActivity::class.java))
    }
}