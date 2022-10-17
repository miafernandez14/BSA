package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityInicialBinding

class InicialActivity : BaseActivity<ActivityInicialBinding>(ActivityInicialBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}