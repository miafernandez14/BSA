package com.fernandez.mia.bullyingsecretalert

import com.fernandez.mia.bullyingsecretalert.databinding.ActivitySplashBinding
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.content.Intent

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate)  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this,InicialActivity::class.java))
                finish()
            },
            3000,
        )
    }
}