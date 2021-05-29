package com.srijan.travelapp.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseUser
import com.srijan.travelapp.utils.PreferenceUtil
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var _scheduleJob: Job? = null

    fun loginUser(context: Context, email: String, pwd: String, onComplete: (user: ParseUser?, exception: Exception?) -> Unit)
    {
        _scheduleJob?.cancel()

        _scheduleJob = viewModelScope.launch {

            if (email.isEmpty() || pwd.isEmpty())
            {
                onComplete(null, Exception("Please fill the required values!"))
            }
            else
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
        }
    }

    fun forgotPassword(context: Context, email: String, onComplete: (Boolean) -> Unit)
    {
        _scheduleJob?.cancel()

        _scheduleJob = viewModelScope.launch {
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
    }


}