package com.shantanu.basedemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shantanu.basedemo.model.User

class UserViewModel : ViewModel() {
    var email = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    //get() = name

    fun setName(){
        name.value=""
    }


    private var userMutableLiveData: MutableLiveData<User>? = null
    val user: LiveData<User>
        get() {
            if (userMutableLiveData == null) {
                userMutableLiveData = MutableLiveData()
            }
            return userMutableLiveData!!
        }

    fun onLoginClicked() {

        val user = User(email.value!!, name.value!!)
        userMutableLiveData!!.setValue(user)
    }


}