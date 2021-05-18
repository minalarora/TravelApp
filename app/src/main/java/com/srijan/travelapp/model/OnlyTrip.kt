package com.srijan.travelapp.model

import com.parse.ParseGeoPoint
import com.parse.ParseUser

data class OnlyTrip(
    var user: ParseUser = ParseUser.getCurrentUser(), var description: String,
    var locationName: String?, var locationCoordinate: ParseGeoPoint?,
    var tag: String = "OTHER", var distance: Int = 0, var duration: Int = 0,
    var time: String?, var date: String?, var coordinateArray: List<String> = emptyList(),
    var type: String?, var likes: Int  = 0, var views: Int = 0)
{
    companion object
    {
        @JvmStatic
        fun createParseObject(obj: OnlyTrip): Post
        {
            var post = Post()
            post.user = obj.user
            post.description = obj.description
            post.locationName = obj.locationName
            post.locationCoordinate = obj.locationCoordinate
            post.tag = obj.tag
            post.distance = obj.distance
            post.duration = obj.duration
            post.time = obj.time
            post.date = obj.date
            post.coordinateArray = obj.coordinateArray.toMutableList()
            post.likes = 0
            post.views = 0
            post.type = obj.type
            return post
        }

        @JvmStatic
        fun createDataObject(obj: Post): OnlyTrip
        {
            return OnlyTrip(user = obj.user ?: ParseUser.getCurrentUser(),
                description = obj.description ?: "",
                locationName = obj.locationName,
                locationCoordinate = obj.locationCoordinate,
                tag = obj.tag ?: "OTHER",
                distance = obj.distance ?: 0,
                duration = obj.duration ?: 0,
                time = obj.time,
                date = obj.date,
                coordinateArray = obj.coordinateArray ?: emptyList(),
                likes = obj.likes ?: 0,
                views = obj.views ?: 0,
                type = obj.type)
        }
    }
}
