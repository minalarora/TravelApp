package com.srijan.travelapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parse.ParseFile
import com.parse.ParseUser
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AddProfileViewModel : ViewModel() {

    private var _scheduleJob: Job? = null

    fun uploadProfile(file: ParseFile, onComplete: (Boolean) -> Unit)
    {
        _scheduleJob?.cancel()

        _scheduleJob = viewModelScope.launch {
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
    }
}