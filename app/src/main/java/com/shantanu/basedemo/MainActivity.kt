package com.shantanu.basedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.shantanu.basedemo.databinding.ActivityMainBinding
import com.shantanu.basedemo.model.User
import com.shantanu.basedemo.viewmodel.UserViewModel
import com.shantanu.basedemo.views.WelcomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //val  userViewModel=UserViewModel()
        val userViewModel = UserViewModel()

        binding.viewModel=userViewModel

        userViewModel.user.observe(this, object : Observer<User> {
            override fun onChanged(@Nullable user: User) {
                if (user.email.length > 0)
                    Toast.makeText(applicationContext, "name : " + user.name + " email " + user.email,
                        Toast.LENGTH_SHORT).show()

               /* val intent=Intent(this@MainActivity,WelcomeActivity::class.java)
                startActivity(intent)*/

            }
        })
    }
}
