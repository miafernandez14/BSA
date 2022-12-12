package com.fernandez.mia.bullyingsecretalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityMainBinding
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = this.intent.extras
    }
}