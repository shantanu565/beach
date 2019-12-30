package com.shantanu.basedemo.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.shantanu.basedemo.R
import com.shantanu.basedemo.databinding.ActivityMainBinding
import com.shantanu.basedemo.databinding.ActivityWelcomeBinding
import com.shantanu.basedemo.model.User
import com.shantanu.basedemo.viewmodel.UserViewModel

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_welcome)

        val binding = DataBindingUtil.setContentView<ActivityWelcomeBinding>(this, R.layout.activity_welcome)
        //val  userViewModel=UserViewModel()
        val userViewModel = UserViewModel()

        binding.viewModel=userViewModel


        Toast.makeText(applicationContext, "first name : " + userViewModel.name,
            Toast.LENGTH_SHORT).show()


        /*userViewModel.name.observe(this, object : Observer<String> {
            override fun onChanged(@Nullable name: String) {
                Toast.makeText(applicationContext, "first name : " + name,
                    Toast.LENGTH_SHORT).show()

                binding.activityWelcomeTextviewName.text=name

            }
        })

*/


        userViewModel.user.observe(this, object : Observer<User> {
            override fun onChanged(@Nullable user: User) {


                binding.activityWelcomeTextviewName.text=user.name

            }
        })
    }
}
