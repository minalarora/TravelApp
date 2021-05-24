package com.srijan.travelapp.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parse.LogInCallback
import com.parse.ParseException
import com.parse.ParseUser
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import com.srijan.travelapp.utils.PreferenceUtil

class SplashViewModel() : ViewModel() {
    private var _scheduleJob: Job? = null

    fun checkCurrentUser(context: Context, onComplete: (Boolean) -> Unit)
    {
        _scheduleJob?.cancel()
        _scheduleJob = viewModelScope.launch {
            if (ParseUser.getCurrentUser() == null)
            {
                val email = PreferenceUtil.getData(context, "email")
                val password = PreferenceUtil.getData(context, "password")
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
    }
}