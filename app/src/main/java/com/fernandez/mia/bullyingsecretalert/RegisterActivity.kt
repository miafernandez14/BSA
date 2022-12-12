package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnRegister.setOnClickListener {
            val userId = "1"
            val sname = binding.name.text.toString()
            val lastname = binding.lastname.text.toString()
            val semail = binding.email.text.toString()
            val ssexo = binding.sexo.text.toString()
            val susername = binding.username.toString()
            val spassword = binding.password.toString()

            val user=User(
                userId,
                sname,
                lastname,
                semail,
                ssexo,
                susername,
                spassword
            )
            sharedPreferenceUtil.saveUser(user)

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    fun login(view: View) {}

}