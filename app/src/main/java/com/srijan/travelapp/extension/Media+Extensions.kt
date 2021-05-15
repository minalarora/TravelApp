package com.srijan.travelapp.extension

import com.parse.ParseFile
import com.parse.ParseQuery
import com.srijan.travelapp.model.Media

fun Media.createMedia(file: ParseFile, type: String, onComplete: (Media?, Exception?) -> Unit)
{
    val media = Media()
    with(media)
    {
        this.media = file
        this.type = type
    }
    media.saveInBackground { e ->
        if (e == null)
        {
            onComplete(media,null)
        }
        else
        {
            onComplete(null,e)
        }
    }
}

fun Media.getMedia(id: String,onComplete: (Media?, Exception?) -> Unit)
{
    val query: ParseQuery<Media> = ParseQuery.getQuery(Media::class.java)
    query.getInBackground(id){ media,exception ->
        if (exception == null)
        {
            onComplete(media,null)
        }
        else
        {
            onComplete(null,exception)
        }
    }
}

fun Media.deleteMedia(media: Media,onComplete: (Boolean) -> Unit)
{
    media.deleteInBackground { e ->
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