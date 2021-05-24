package com.srijan.travelapp.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseUser
import com.srijan.travelapp.utils.PreferenceUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CreateUserViewModel : ViewModel() {

    private var _scheduleJob: Job? = null

    fun createUser(context: Context, email: String, pwd: String, name: String, onComplete: (user: ParseUser?, exception: Exception?) -> Unit)
    {
// other fields can be set just like with ParseObject
//user.put("phone", "650-253-0000");

        _scheduleJob?.cancel()

        _scheduleJob = viewModelScope.launch {
            try {
                if (email.isEmpty() || pwd.isEmpty() || name.isEmpty())
                {
                    onComplete(null, Exception("Please fill the required values!"))
                }
                else
                {
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
            }
            catch (e: Exception)
            {
                onComplete(null, e)
            }
        }
    }
}