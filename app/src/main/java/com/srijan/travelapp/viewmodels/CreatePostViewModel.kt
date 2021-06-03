package com.srijan.travelapp.viewmodels

import android.Manifest
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.parse.LocationCallback
import com.srijan.travelapp.R
import com.srijan.travelapp.ui.CreatePostActivity
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.URLConnection
import java.util.*

class CreatePostViewModel : ViewModel() {

    private var _scheduleJob: Job? = null
    private val _imageList = MutableLiveData<List<String>>()
    private val REQUEST_CODE_CHOOSE_MEDIA = 101
    private val REQUEST_CODE_CHOOSE_LOCATION = 102
    private val _error = MutableLiveData<String>()


    val imageList: LiveData<List<String>> = _imageList
    val error: LiveData<String> = _error

    fun updateImageList(list: List<String>)
    {
        _imageList.setValue(list)
    }

    fun isImageFile(path: String?): Boolean {
        val mimeType: String = URLConnection.guessContentTypeFromName(path)
        return mimeType.startsWith("image")
    }

    fun isVideoFile(path: String?): Boolean {
        val mimeType: String = URLConnection.guessContentTypeFromName(path)
        return mimeType.startsWith("video")
    }

    fun askPermissionForGallery(context: Context) {
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
        val rationale = "Please provide Storage or Camera permission to upload media"
        val options = Permissions.Options()
            .setRationaleDialogTitle("Info")
            .setSettingsDialogTitle("Warning")
        Permissions.check(
            context /*context*/,
            permissions,
            rationale,
            options,
            object : PermissionHandler() {
                override fun onGranted() {
                    openStorageForGallery(context)
                }

                override fun onDenied(
                    context: Context,
                    deniedPermissions: java.util.ArrayList<String>
                ) {
                    _error.value = "Unable to grant permissions!"
                }
            })
    }

    fun askPermissionForLocation(context: Context) {
        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
        val rationale = "Please provide permission to access your location!"
        val options = Permissions.Options()
            .setRationaleDialogTitle("Info")
            .setSettingsDialogTitle("Warning")
        Permissions.check(
            context /*context*/,
            permissions,
            rationale,
            options,
            object : PermissionHandler() {
                override fun onGranted() {
                    fetchLocation(context)
                }

                override fun onDenied(
                    context: Context,
                    deniedPermissions: java.util.ArrayList<String>
                ) {
                    _error.value = "Unable to grant permissions!"
                }
            })
    }

    private fun openStorageForGallery(context: Context) {
        Matisse.from(context as CreatePostActivity)
            .choose(MimeType.ofAll(), true)
            .countable(true)
            .maxSelectable(5)
            .gridExpectedSize(
                context.resources.getDimensionPixelSize(R.dimen.album_item)
            )
            .showPreview(true)
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            .thumbnailScale(0.85f)
            .imageEngine(GlideEngine())
            .autoHideToolbarOnSingleTap(true)
            .theme(R.style.matisse)
//            .capture(true)
//            .captureStrategy(CaptureStrategy(true,"com."))
            .forResult(REQUEST_CODE_CHOOSE_MEDIA)
    }

    private fun fetchLocation(context: Context)
    {
        _scheduleJob?.cancel()

        _scheduleJob = viewModelScope.launch {
            try {


            }
            catch (e: Exception)
            {

            }
        }

    }




}