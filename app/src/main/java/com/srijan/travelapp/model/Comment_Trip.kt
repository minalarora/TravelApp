package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Comment_Trip")
class Comment_Trip: ParseObject() {
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

    var trip: Trip?
        get() = getParseObject("trip") as Trip
        set(value) {
            if (value != null) {
                put("trip",value)
            }
            else
            {
                put("trip",Trip())
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