package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseGeoPoint
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

    var media: MutableList<String>?
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



    var views: Int?
        get() = getInt("views")
        set(value) {
            if (value != null) {
                put("views",value)
            }
            else
            {
                put("views",0)
            }
        }

    var location: ParseGeoPoint?
        get() = getParseGeoPoint("location")
        set(value) {
            if (value != null) {
                put("location",value)
            }
        }

    var comments: MutableList<String>?
        get() = getList("comments")
        set(value) {
            if (value != null) {
                put("comments",value)
            }
            else
            {
                put("comments", MutableList(0) {

                })
            }
        }






}