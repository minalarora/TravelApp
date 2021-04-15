package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Post")
class Post : ParseObject(){


     var user: ParseUser?
         get() = getParseUser("user")
         set(value) {
             if (value != null) {
                 put("user",value)
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

    var media: MutableList<Media>?
        get() = getList("media")
        set(value) {
            if (value != null) {
                put("media",value)
            }
            else
            {
                put("media", MutableList(0) {

                })
            }
        }

     var like: Int?
         get() = getInt("like")
         set(value) {
             if (value != null) {
                 put("like",value)
             }
             else
             {
                 put("like",0)
             }
         }

    var comment: MutableList<Comment>?
        get() = getList("comment")
        set(value) {
            if (value != null) {
                put("comment",value)
            }
            else
            {
                put("comment", MutableList(0) {

                })
            }
        }


    var view: Int?
        get() = getInt("view")
        set(value) {
            if (value != null) {
                put("view",value)
            }
            else
            {
                put("view",0)
            }
        }


}