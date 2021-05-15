package com.srijan.travelapp.extension

import com.parse.ParseQuery
import com.parse.ParseUser
import com.srijan.travelapp.model.Comment
import com.srijan.travelapp.model.Post

fun Comment.addComment(post: Post, text: String, onComplete: (Comment?, Exception?) -> Unit)
{
    if (ParseUser.getCurrentUser()!=null)
    {
        val comment = Comment()
        comment.user = ParseUser.getCurrentUser()
        comment.text = text
        comment.post = post
        comment.saveInBackground { e ->
            if (e==null)
            {
                onComplete(comment, null)
            }
            else
            {
                onComplete(null, e)
            }
        }
    }
    else
    {
        onComplete(null, Exception("User not found!"))
    }
}

fun Comment.deleteComment(comment: Comment, onComplete: (Boolean) -> Unit)
{
    comment.deleteInBackground { e ->
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

fun Comment.updateComment(comment: Comment, text: String , onComplete: (Comment?, Exception?) -> Unit )
{
    comment.text = text
    comment.saveInBackground { e ->
        if (e == null)
        {
            onComplete(comment,null)
        }
        else
        {
            onComplete(null,e)
        }
    }
}

fun Comment.addLike(comment: Comment, onComplete: (Boolean) -> Unit)
{
    comment.increment("likes")
    comment.saveInBackground { e ->
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

fun Comment.getAllComment(post: Post, onComplete: (List<Comment>, Exception?) -> Unit)
{
    val query: ParseQuery<Comment> = ParseQuery.getQuery(Comment::class.java)
    query.whereEqualTo("post",post)
    query.orderByDescending("likes")
    query.findInBackground { objects, e ->
        when {
            objects!=null -> onComplete(objects, null)
            e!=null -> onComplete(emptyList(), e)
        }
    }
}
