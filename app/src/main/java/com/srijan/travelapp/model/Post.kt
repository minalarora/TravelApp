package com.srijan.travelapp.model

import com.parse.*

@ParseClassName("Post")
class Post : ParseObject(){


     var user: ParseUser?
         get() = getParseUser("user")
         set(value) {
             if (value != null) {
                 put("user",value)
             }
         }


    var title: String?
        get() = getString("title").toString()
        set(value) {
            if (value != null) {
                put("title",value)
            }
            else
            {
                put("title","")
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

    var tag: String?
        get() = getString("tag").toString()
        set(value) {
            if (value != null) {
                put("tag",value)
            }
            else
            {
                put("tag","")
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

    var locationName: String?
        get() = getString("location_name").toString()
        set(value) {
            if (value != null) {
                put("location_name",value)
            }
            else
            {
                put("location_name","")
            }
        }

    var locationCoordinate: ParseGeoPoint?
        get() = getParseGeoPoint("location_cn")
        set(value) {
            if (value != null) {
                put("location_cn",value)
            }
        }

    var time: String?
        get() = getString("time").toString()
        set(value) {
            if (value != null) {
                put("time",value)
            }
            else
            {
                put("time","")
            }
        }

    var date: String?
        get() = getString("date").toString()
        set(value) {
            if (value != null) {
                put("date",value)
            }
            else
            {
                put("date","")
            }
        }

    var price: Int?
        get() = getInt("price")
        set(value) {
            if (value != null) {
                put("price",value)
            }
            else
            {
                put("price",0)
            }
        }

    var going: ParseRelation<ParseUser>?
        get() = getRelation("going")
        set(value) {
            if (value != null) {
                put("going",value)
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

    var coordinateArray: MutableList<String>?
        get() = getList("cn_array")
        set(value) {
            if (value != null) {
                put("cn_array",value)
            }
            else
            {
                put("cn_array", MutableList(0) {

                })
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
                put("type","")
            }
        }

}