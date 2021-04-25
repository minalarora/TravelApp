package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Comment_Event")
class Comment_Event: ParseObject() {
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

    var event: Event?
        get() = getParseObject("event") as Event
        set(value) {
            if (value != null) {
                put("event",value)
            }
            else
            {
                put("event",Event())
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