package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject

@ParseClassName("Media")
class Media: ParseObject() {
    var media: ParseFile?
        get() = getParseFile("media")
        set(value) {
            if (value != null) {
                put("media",value)
            }
        }

    var type: String?
        get() = getString("type").toString()
        set(value) {
            if (value != null) {
                put("type",value)
            }
            else
            {
                put("type","OTHER")
            }
        }
    //IMAGE OR VIDEO
}