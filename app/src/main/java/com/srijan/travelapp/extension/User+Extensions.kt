package com.srijan.travelapp.extension

import android.content.Context
import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseFile
import com.parse.ParseUser
import com.srijan.travelapp.utils.PreferenceUtil


fun ParseUser.checkCurrentUser(context: Context, onComplete: (Boolean) -> Unit)
{
    if (ParseUser.getCurrentUser() == null)
    {
        var email = PreferenceUtil.getData(context, "email")
        var password = PreferenceUtil.getData(context, "password")
        if (email == null || password == null)
        {
            onComplete(false)
        }
        else
        {
            ParseUser.logInInBackground(email, password, object : LogInCallback {
                override fun done(user: ParseUser?, e: ParseException?) {
                    if (e == null) {
                        onComplete(true)
                    } else {
                        onComplete(false)
                    }
                }

            })
        }
    }
    else
    {
        onComplete(true)
    }
}

fun ParseUser.loginUser(context: Context, email: String, pwd: String, onComplete: (user: ParseUser?, exception: Exception?) -> Unit)
{
    ParseUser.logInInBackground(email, pwd, object : LogInCallback {
        override fun done(user: ParseUser?, e: ParseException?) {
            if (e == null && user != null) {
                PreferenceUtil.putData(context, "email", email)
                PreferenceUtil.putData(context, "password", pwd)
            }
            onComplete(user, e)
        }

    })
}


fun ParseUser.createUser(context: Context, email: String, pwd: String, name: String, onComplete: (user: ParseUser?, exception: Exception?) -> Unit)
{
// other fields can be set just like with ParseObject
//user.put("phone", "650-253-0000");

    try {
        val user = ParseUser()
        with(user)
        {
            username = email
            setEmail(email)
            setPassword(pwd)
            put("name",name)
        }
        user.signUpInBackground { exception ->
            if (exception == null) {

                if (ParseUser.getCurrentUser() == null)
                {
                    ParseUser.logInInBackground(email, pwd, object : LogInCallback {
                        override fun done(user: ParseUser?, e: ParseException?) {
                            if (e == null && user != null) {
                                PreferenceUtil.putData(context, "email", email)
                                PreferenceUtil.putData(context, "password", pwd)
                            }
                            onComplete(ParseUser.getCurrentUser(), e)
                        }

                    })
                }
                else
                {
                    PreferenceUtil.putData(context, "email", email)
                    PreferenceUtil.putData(context, "password", pwd)
                    onComplete(ParseUser.getCurrentUser(), exception)
                }
            } else {
                    onComplete(null, exception)
            }
        }

    }
    catch (e: Exception)
    {
        onComplete(null, e)
    }
}


fun ParseUser.forgotPassword(context: Context, email: String, onComplete: (Boolean) -> Unit)
{
    ParseUser.requestPasswordResetInBackground(email) { e ->
        if (e == null) {
            onComplete(true)
            // An email was successfully sent with reset instructions.
        } else {
            onComplete(false)
            // Something went wrong. Look at the ParseException to see what's up.
        }
    }
}

fun ParseUser.uploadProfile(file: ParseFile,onComplete: (Boolean) -> Unit)
{
    var user= ParseUser.getCurrentUser()
    user.put("profile",file)
    user.saveInBackground{ exception  ->
        if (exception == null)
        {
            onComplete(true)
        }
        else
        {
            onComplete(false)
        }

    }
}