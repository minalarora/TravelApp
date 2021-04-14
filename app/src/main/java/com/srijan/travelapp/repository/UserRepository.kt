package com.srijan.travelapp.repository

import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseUser
import com.srijan.travelapp.model.User
import java.lang.Exception

class UserRepository {


    companion object {
        @JvmStatic
        fun createUser(
            name: String,
            email: String,
            password: String,
            onComplete: (User?, Exception?) -> Unit
        ) {
            val user = User()
            with(user)
            {
                setName(name)
                setEmail(email)
                setPassword(password)
                username = email
            }
            user.signUpInBackground { e ->
                if (e == null) {
                    onComplete(user, null)
                } else {
                    onComplete(null, e)
                }

            }
        }

        @JvmStatic
        fun loginUser(email: String, password: String, onComplete: (User?, Exception?) -> Unit) {
            ParseUser.logInInBackground(email, password, object : LogInCallback {
                override fun done(user: ParseUser?, e: ParseException?) {
                    onComplete(User(user), e)
                }

            })
        }

        @JvmStatic
        fun logoutUser(onComplete: (Boolean?) -> Unit) {
            ParseUser.logOutInBackground { e ->
                if (e == null) {
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
        }
    }
}