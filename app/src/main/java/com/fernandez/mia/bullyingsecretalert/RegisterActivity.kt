package com.fernandez.mia.bullyingsecretalert

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fernandez.mia.bullyingsecretalert.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = RegisterViewModel(this)

        registerViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.userExist.observe(this){
            Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show()
        }

        binding.btnRegister2.setOnClickListener{
            registerViewModel.saveUser(
                "",
                binding.Name.text.toString(),
                binding.Email.text.toString(),
                binding.Sex.text.toString(),
                binding.Username.text.toString(),
                binding.Password.text.toString()
            )
        }

        registerViewModel.goRegisterActivity.observe(this){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnLogin2.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
