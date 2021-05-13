package com.srijan.travelapp.repository

import com.parse.ParseQuery
import com.parse.ParseUser


class PostRepository {
    companion object {
//        @JvmStatic
//        fun createPost(t: String?, m: MutableList<String>, onComplete: (Post?, Exception?) -> Unit)
//        {
//            if (ParseUser.getCurrentUser()!=null) {
//
//                var p = Post()
//                with(p)
//                {
//                    user = ParseUser.getCurrentUser()
//                    text = t
//                    media = m
//                }
//                p.saveInBackground { e ->
//                    if (e == null) {
//                        onComplete(p, null)
//                    } else {
//                        onComplete(null, e)
//                    }
//                }
//            }
//            else
//            {
//                onComplete(null, Exception("User not found!"))
//            }
//        }
//
//        @JvmStatic
//        fun getPost(user: ParseUser, onComplete: (MutableList<Post>?, Exception?) -> Unit)
//        {
//            val query: ParseQuery<Post> = ParseQuery.getQuery(Post::class.java)
//            query.whereEqualTo("user", user)
//
//            query.findInBackground { objects, e ->
//                if (e == null && objects.isNotEmpty()) {
//                    // The query was successful.
//                    onComplete(objects, null)
//
//                } else {
//                    // Something went wrong.
//                    onComplete(null, e)
//                }
//            }
//        }
//
//        @JvmStatic
//        fun addComment(p: Post, c: String, onComplete: (Comment?, Exception?) -> Unit)
//        {
//
//            if (ParseUser.getCurrentUser()!=null)
//            {
//                val comment = Comment()
//                comment.user = ParseUser.getCurrentUser()
//                comment.text = c
//                comment.post = p
//                comment.saveInBackground { e ->
//                    if (e==null)
//                    {
//                        onComplete(comment, null)
//                    }
//                    else
//                    {
//                        onComplete(comment, e)
//                    }
//                }
//            }
//            else
//            {
//                onComplete(null, Exception("User not found!"))
//            }
//        }
//
//
//    }
    }
}