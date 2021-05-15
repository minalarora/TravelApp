package com.srijan.travelapp.extension

import com.parse.ParseGeoPoint
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser
import com.srijan.travelapp.model.Post
import java.util.*


fun Post.getFollowingPost(list: List<ParseUser>, page: Int, onComplete: (List<Post>, Exception?) -> Unit)
{
    val objectIdArray: List<String> = list.map {  it.objectId }
    if (objectIdArray.isEmpty())
    {
        onComplete( emptyList(), null)
    }
    else
    {
        var limit = 100
        var skip = limit * (page - 1)
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.whereNotEqualTo("user",ParseUser.getCurrentUser())
        query.whereContainedIn("followers", objectIdArray);
        query.orderByDescending("createdAt");
        query.limit = limit
        query.skip = skip
        query.findInBackground { objects, e ->
            when {
                objects!=null -> onComplete(objects, null)
                e!=null -> onComplete(emptyList(), e)
            }
        }

    }
}

fun Post.getMyPost(page: Int, onComplete: (List<Post>, Exception?) -> Unit)
{

        var limit = 100
        var skip = limit * (page - 1)
        val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
        query.whereEqualTo("user",ParseUser.getCurrentUser())
        query.orderByDescending("createdAt");
        query.limit = limit
        query.skip = skip
        query.findInBackground { objects, e ->
            when {
                objects!=null -> onComplete(objects, null)
                e!=null -> onComplete(emptyList(), e)
            }
        }
}

fun Post.getNearPost(location: ParseGeoPoint, page: Int, onComplete: (List<Post>, Exception?) -> Unit)
{

    var limit = 100
    var skip = limit * (page - 1)
    val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
    query.whereNotEqualTo("user",ParseUser.getCurrentUser())
    query.whereNear("location_cn",location)
    query.limit = limit
    query.skip = skip
    query.findInBackground { objects, e ->
        when {
            objects!=null -> onComplete(objects, null)
            e!=null -> onComplete(emptyList(), e)
        }
    }
}

fun Post.getTrendingPost(page: Int, onComplete: (List<Post>, Exception?) -> Unit)
{

    var limit = 100
    var skip = limit * (page - 1)
    val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
    query.whereNotEqualTo("user",ParseUser.getCurrentUser())
    query.orderByDescending("likes");
    query.limit = limit
    query.skip = skip
    query.findInBackground { objects, e ->
        when {
            objects!=null -> onComplete(objects, null)
            e!=null -> onComplete(emptyList(), e)
        }
    }
}

fun Post.addView(post: Post, onComplete: (Boolean) -> Unit)
{
    post.increment("views")
    post.saveInBackground { e ->
        if (e == null)
        {
            onComplete(true)
        }
        else
        {
            onComplete(false)
        }
    }
}

fun Post.addLike(post: Post, onComplete: (Boolean, Exception?) -> Unit)
{
    post.increment("likes")
    post.saveInBackground { e ->
        if (e == null)
        {
            onComplete(true , e)
        }
        else
        {
            onComplete(false , e)
        }
    }
}




