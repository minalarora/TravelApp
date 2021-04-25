package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Comment_Post")
class Comment_Post: ParseObject() {
    var user: ParseUser?
        get() = getParseUser("user")
        set(value) {
            if (value != null) {
                put("user",value)
            }
            else
            {
                put("user",ParseUser.getCurrentUser())
            }
        }

    var post: Post?
        get() = getParseObject("post") as Post
        set(value) {
            if (value != null) {
                put("post",value)
            }
            else
            {
                put("post",Post())
            }
        }

    var text: String?
        get() = getString("text").toString()
        set(value) {
            if (value != null) {
                put("text",value)
            }
            else
            {
                put("text","")
            }
        }

    var likes: Int?
        get() = getInt("likes")
        set(value) {
            if (value != null) {
                put("likes",value)
            }
            else
            {
                put("likes",0)
            }
        }
}