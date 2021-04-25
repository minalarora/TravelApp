package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Timeline")
class Timeline: ParseObject() {
    var user: ParseUser?
        get() = getParseUser("user")
        set(value) {
            if (value != null) {
                put("user",value)
            }
        }

    var data: ParseObject?
        get() = getParseObject("data")
        set(value) {
            if (value != null) {
                put("data",value)
            }
        }

    var type: String?
        get() = getString("type")
        set(value) {
            if (value != null) {
                put("type",value)
            }
        }
}