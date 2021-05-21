package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseRelation
import com.parse.ParseUser

@ParseClassName("Chat")
class Chat : ParseObject() {

    var users: MutableList<String>?
        get() = getList("users")
        set(value) {
            if (value != null) {
                put("users",value)
            }
        }

    var messages: ParseRelation<Message>?
        get() = getRelation("messages")
        set(value) {
            if (value != null) {
                put("messages",value)
            }
        }
}