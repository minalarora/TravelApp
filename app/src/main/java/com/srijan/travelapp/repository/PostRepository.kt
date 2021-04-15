package com.srijan.travelapp.repository

import com.parse.ParseUser
import com.srijan.travelapp.model.Media
import com.srijan.travelapp.model.Post
import com.srijan.travelapp.model.User
import java.text.ParseException

class PostRepository {
    companion object
    {
        @JvmStatic
        fun createPost(t: String?,m:MutableList<Media>?, onComplete: (Post?, Exception?) -> Unit)
        {
            if (ParseUser.getCurrentUser()!=null) {
                var p = Post()
                with(p)
                {
                    user = ParseUser.getCurrentUser()
                    text = t
                    media = m
                }
                p.saveInBackground { e ->
                    if (e == null) {
                        onComplete(p, null)
                    } else {
                        onComplete(null, e)
                    }
                }
            }
            else
            {
                onComplete(null,java.lang.Exception("User not found!"))
            }
        }
    }
}