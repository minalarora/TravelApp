package com.srijan.travelapp.ui

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityCreatePostBinding
import com.srijan.travelapp.databinding.ActivityHomeBinding
import com.srijan.travelapp.viewmodels.CreatePostViewModel
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine

class CreatePostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePostBinding
    private val REQUEST_CODE_CHOOSE_MEDIA = 101
    private val REQUEST_CODE_CHOOSE_LOCATION = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityCreatePostBinding>(this, R.layout.activity_create_post)
            .apply {
                lifecycleOwner = this@CreatePostActivity
                viewModel = ViewModelProvider(this@CreatePostActivity).get(CreatePostViewModel::class.java)
                    .apply {

                    }

            }

            askPermissionForGallery()

    }

    private fun askPermissionForGallery() {
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
        val rationale = "Please provide Storage or Camera permission to upload media"
        val options = Permissions.Options()
            .setRationaleDialogTitle("Info")
            .setSettingsDialogTitle("Warning")
        Permissions.check(
            this /*context*/,
            permissions,
            rationale,
            options,
            object : PermissionHandler() {
                override fun onGranted() {
                    openStorageForGallery()
                }

                override fun onDenied(
                    context: Context,
                    deniedPermissions: java.util.ArrayList<String>
                ) {
                    Toast.makeText(this@CreatePostActivity,"Unable to grant permissions!",Toast.LENGTH_LONG).show()
                    finish()
                    // permission denied, block the feature.
                }
            })
    }

    private fun openStorageForGallery() {
        Matisse.from(this)
            .choose(MimeType.ofImage(), true)
            .countable(true)
            .maxSelectable(5)
            .gridExpectedSize(
                resources.getDimensionPixelSize(R.dimen.album_item)
            )
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
            .thumbnailScale(0.85f)
            .imageEngine(GlideEngine())
            .autoHideToolbarOnSingleTap(true)
            .forResult(REQUEST_CODE_CHOOSE_MEDIA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_CHOOSE_MEDIA && data != null) {
                binding.viewModel?.updateImageList(Matisse.obtainPathResult(data))
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
        setCurrentFragment(CreatePostFragment(),"createpost")
        Log.d("minal",binding.viewModel?.imageList?.value.toString())
    }

    private fun setCurrentFragment(fragment: Fragment, tag: String)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id,fragment,tag)
            commit()
        }
    }
}