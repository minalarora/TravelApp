package com.srijan.travelapp.model

import com.parse.Parse
import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Message")
class Message : ParseObject() {

    var message: String?
        get() = getString("message").toString()
        set(value) {
            if (value != null) {
                put("message",value)
            }
        }

    var type: String?
        get() = getString("type").toString()
        set(value) {
            if (value != null) {
                put("type",value)
            }
        }

    var date: String?
        get() = getString("date").toString()
        set(value) {
            if (value != null) {
                put("date",value)
            }
        }

    var who: ParseUser?
        get() = getParseUser("who")
        set(value) {
            if (value != null) {
                put("who",value)
            }
        }

//    var chat: Chat?
//        get() = getParseObject("chat") as Chat
//        set(value) {
//            if (value != null) {
//                put("chat",value)
//            }
//        }
}