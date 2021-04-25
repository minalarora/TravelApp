package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseGeoPoint
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Trip")
class Trip : ParseObject(){


    var user: ParseUser?
        get() = getParseUser("user")
        set(value) {
            if (value != null) {
                put("user",value)
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

    var duration: Int?
        get() = getInt("duration")
        set(value) {
            if (value != null) {
                put("duration",value)
            }
            else
            {
                put("duration",0)
            }
        }



    var description: String?
        get() = getString("description").toString()
        set(value) {
            if (value != null) {
                put("description",value)
            }
            else
            {
                put("description","")
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

    var coordinates: MutableList<String>?
        get() = getList("coordinates")
        set(value) {
            if (value != null) {
                put("coordinates",value)
            }
            else
            {
                put("coordinates", MutableList(0) {

                })
            }
        }

}