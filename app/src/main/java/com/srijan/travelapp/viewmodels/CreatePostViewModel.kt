package com.srijan.travelapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class CreatePostViewModel : ViewModel() {

    private var _scheduleJob: Job? = null
    private val _imageList = MutableLiveData<List<String>>()

    val imageList: LiveData<List<String>> = _imageList

    fun updateImageList(list: List<String>)
    {
        _imageList.setValue(list)
    }


}