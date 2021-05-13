package com.srijan.travelapp.repository

import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser


class UserRepository {


    companion object {
//        @JvmStatic
//        fun createUser(
//            name: String,
//            email: String,
//            password: String,
//            onComplete: (User?, Exception?) -> Unit
//        ) {
//            val user = User()
//            with(user)
//            {
//                setName(name)
//                setEmail(email)
//                setPassword(password)
//                username = email
//            }
//            user.signUpInBackground { e ->
//                if (e == null) {
//                    onComplete(user, null)
//                } else {
//                    onComplete(null, e)
//                }
//
//            }
//        }
//
//        @JvmStatic
//        fun loginUser(email: String, password: String, onComplete: (User?, Exception?) -> Unit) {
//            ParseUser.logInInBackground(email, password, object : LogInCallback {
//                override fun done(user: ParseUser?, e: ParseException?) {
//                    onComplete(User(user), e)
//                }
//
//            })
//        }
//
//        @JvmStatic
//        fun getUserByEmail(email: String, onComplete: (User?, Exception?) -> Unit)
//        {
//            val query = ParseUser.getQuery()
//            query.whereEqualTo("email", email)
//            query.findInBackground { objects, e ->
//                if (e == null && objects.isNotEmpty()) {
//                    // The query was successful.
//                    onComplete(User(objects[0]),null)
//
//                } else {
//                    // Something went wrong.
//                    onComplete(null,e)
//                }
//            }
//        }

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