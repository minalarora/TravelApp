package com.srijan.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.parse.ParseUser
import com.srijan.travelapp.databinding.ActivityMainBinding
import com.srijan.travelapp.model.User
import com.srijan.travelapp.repository.UserRepository
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var activity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        UserRepository.createUser("Minal Arora","minaalarora567@gmail.com","123456")
//        {
//            user: User?, exception: Exception? ->
//            when
//            {
//                user!=null -> {
//                    Toast.makeText(this, user.username, Toast.LENGTH_SHORT).show()
//                }
//                exception!=null -> {
//                    Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//
//        }

//        UserRepository.loginUser("minaalarora567@gmail.com","123456"){
//                user: User?, exception: Exception? ->
//            when
//            {
//                user!=null -> {
//                    Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show()
//                }
//                exception!=null -> {
//                    Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }

//        UserRepository.logoutUser {
//            b: Boolean? ->
//            Toast.makeText(this, "" + b, Toast.LENGTH_SHORT).show()
//        }
    }
}