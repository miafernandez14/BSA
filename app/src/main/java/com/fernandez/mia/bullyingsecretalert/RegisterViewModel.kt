package com.fernandez.mia.bullyingsecretalert

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel (private val context: Context): ViewModel(){
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val goRegisterActivity = MutableLiveData<Boolean>()
    val emptyFieldsError = MutableLiveData<Boolean>()
    val userExist = MutableLiveData<Boolean>()

    init {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun saveUser(userId: String, name: String , email: String, sex: String, userName: String, password: String) {
        val user = User(
            userId,
            name,
            email,
            sex,
            userName,
            password
        )

        val user2: User? = sharedPreferenceUtil.getUser()

        if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            emptyFieldsError.postValue(true)
        } else if (userName == user2?.username && password == user2?.password){
            userExist.postValue(true)
        } else {
            sharedPreferenceUtil.saveUser(user)
            goRegisterActivity.postValue(true)
        }
    }
}