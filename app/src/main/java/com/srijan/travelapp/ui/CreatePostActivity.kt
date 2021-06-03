package com.srijan.travelapp.ui


import android.content.Intent
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mapbox.search.*
import com.mapbox.search.result.SearchResult
import com.mapbox.search.result.SearchSuggestion
import com.srijan.travelapp.R
import com.srijan.travelapp.databinding.ActivityCreatePostBinding
import com.srijan.travelapp.databinding.ActivityHomeBinding
import com.srijan.travelapp.viewmodels.CreatePostViewModel
import com.zhihu.matisse.Matisse

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

                        askPermissionForGallery(this@CreatePostActivity)
                        askPermissionForLocation(this@CreatePostActivity)

                        error.observe(this@CreatePostActivity, {
                            Toast.makeText(this@CreatePostActivity,it,Toast.LENGTH_LONG).show()
                            this@CreatePostActivity.finish()
                        })
                    }

            }

        searchEngine = MapboxSearchSdk.createSearchEngine()

        searchRequestTask = searchEngine.search(
            "Nehru Nagar",
            SearchOptions(limit = 5),
            searchCallback
        )


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_CHOOSE_MEDIA && data != null) {
                binding.viewModel?.updateImageList(Matisse.obtainPathResult(data))
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
        setCurrentFragment(CreatePostFragment(),"createpost")

    }

    private fun setCurrentFragment(fragment: Fragment, tag: String)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id,fragment,tag)
            commit()
        }
    }

    private lateinit var searchEngine: SearchEngine
    private lateinit var searchRequestTask: SearchRequestTask

    private val searchCallback = object : SearchSelectionCallback {

        override fun onSuggestions(suggestions: List<SearchSuggestion>, responseInfo: ResponseInfo) {
            if (suggestions.isEmpty()) {
                Log.i("SearchApiExample", "No suggestions found")
            } else {
                Log.i("SearchApiExample", "Search suggestions: $suggestions.\nSelecting first suggestion...")
                //this will call onResult
                 searchRequestTask = searchEngine.select(suggestions.first(), this)
            }
        }

        override fun onResult(
            suggestion: SearchSuggestion,
            result: SearchResult,
            responseInfo: ResponseInfo
        ) {
            Log.i("SearchApiExample", "Search result: ${result.name}")
            Log.i("SearchApiExample", "Search result: $result")
        }

        override fun onCategoryResult(
            suggestion: SearchSuggestion,
            results: List<SearchResult>,
            responseInfo: ResponseInfo
        ) {
            Log.i("SearchApiExample", "Category search results: $results")
        }

        override fun onError(e: Exception) {
            Log.i("SearchApiExample", "Search error", e)
        }
    }
}