package com.srijan.travelapp.model

import com.parse.ParseGeoPoint
import com.parse.ParseRelation
import com.parse.ParseUser

data class OnlyEvent(var user: ParseUser = ParseUser.getCurrentUser(), var title: String,
                     var description: String, var tag: String = "OTHER", var media: List<String> = emptyList(),
                     var locationName: String?, var locationCoordinate: ParseGeoPoint?,
                     var time: String?, var date: String?, var price: Int = 0, var going: ParseRelation<ParseUser>?,
                     var likes: Int  = 0, var views: Int = 0 )
{
    companion object
    {
        @JvmStatic
        fun createParseObject(obj: OnlyEvent): Post
        {
            var post = Post()
            post.user = obj.user
            post.title = obj.title
            post.description = obj.description
            post.locationName = obj.locationName
            post.locationCoordinate = obj.locationCoordinate
            post.tag = obj.tag
            post.media = obj.media.toMutableList()
            post.time = obj.time
            post.date = obj.date
            post.price = obj.price
            post.likes = 0
            post.views = 0
            post.type = "EVENT"
            return post
        }

        @JvmStatic
        fun createDataObject(obj: Post): OnlyEvent
        {
            return OnlyEvent(user = obj.user ?: ParseUser.getCurrentUser(),
                title = obj.title ?: "",
                description = obj.description ?: "",
                locationName = obj.locationName,
                locationCoordinate = obj.locationCoordinate,
                tag = obj.tag ?: "OTHER",
                media = obj.media ?: emptyList(),
                time = obj.time,
                date = obj.date,
                price = obj.price ?: 0,
                going = obj.going,
                likes = obj.likes ?: 0,
                views = obj.views ?: 0)

        }
    }
}
