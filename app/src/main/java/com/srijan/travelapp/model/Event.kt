package com.srijan.travelapp.model


import com.parse.*

@ParseClassName("Event")
class Event : ParseObject(){


    var user: ParseUser?
        get() = getParseUser("user")
        set(value) {
            if (value != null) {
                put("user",value)
            }
        }

    var cover: ParseFile?
        get() = getParseFile("cover")
        set(value) {
            if (value != null) {
                put("cover",value)
            }
        }

    var date: String?
        get() = getString("date")
        set(value) {
            if (value != null) {
                put("date",value)
            }
        }

    var time: String?
        get() = getString("time")
        set(value) {
            if (value != null) {
                put("time",value)
            }
        }

    var name: String?
        get() = getString("name")
        set(value) {
            if (value != null) {
                put("name",value)
            }
        }

    var price: Int?
        get() = getInt("price")
        set(value) {
            if (value != null) {
                put("price",value)
            }
        }

    var location_name: String?
        get() = getString("location_name")
        set(value) {
            if (value != null) {
                put("location_name",value)
            }
        }

    var location_coordinates: ParseGeoPoint?
        get() = getParseGeoPoint("location_coordinates")
        set(value) {
            if (value != null) {
                put("location_coordinates",value)
            }
        }

    var link: String?
        get() = getString("link")
        set(value) {
            if (value != null) {
                put("link",value)
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

    var going: ParseRelation<ParseUser>?
        get() = getRelation("going")
        set(value) {
            if (value != null) {
                put("going",value)
            }
        }






}