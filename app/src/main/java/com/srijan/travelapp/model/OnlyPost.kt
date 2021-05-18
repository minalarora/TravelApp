package com.srijan.travelapp.model

import com.parse.ParseGeoPoint
import com.parse.ParseUser

data class OnlyPost(var user: ParseUser = ParseUser.getCurrentUser(), var title: String,
                    var locationName: String?, var locationCoordinate: ParseGeoPoint?,
                    var tag: String = "OTHER", var media: List<String> = emptyList(),
                    var likes: Int  = 0, var views: Int = 0)
{
    companion object
    {
        @JvmStatic
        fun createParseObject(obj: OnlyPost): Post
        {
            var post = Post()
            post.user = obj.user
            post.title = obj.title
            post.locationName = obj.locationName
            post.locationCoordinate = obj.locationCoordinate
            post.tag = obj.tag
            post.media = obj.media.toMutableList()
            post.likes = 0
            post.views = 0
            post.type = "POST"
            return post
        }

        @JvmStatic
        fun createDataObject(obj: Post): OnlyPost
        {
            return OnlyPost(user = obj.user ?: ParseUser.getCurrentUser(),
                                title = obj.title ?: "",
                                locationName = obj.locationName,
                                locationCoordinate = obj.locationCoordinate,
                                tag = obj.tag ?: "OTHER",
                                media = obj.media ?: emptyList(),
                                likes = obj.likes ?: 0,
                                views = obj.views ?: 0 )

        }
    }
}
