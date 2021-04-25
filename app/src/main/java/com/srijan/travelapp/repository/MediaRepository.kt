package com.srijan.travelapp.repository

import android.util.Log
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseQuery
import com.srijan.travelapp.model.Media
import com.srijan.travelapp.model.Post
import java.io.File

class MediaRepository {
    companion object
    {
        @JvmStatic
        fun addMediaByByteArray(file: ByteArray,type: String,onComplete: (String?, Exception?) -> Unit)
        {
            val parseFile = ParseFile(file)
            val media = Media()
            with(media)
            {
                this.media = parseFile
                this.type = type
            }
            media.saveInBackground { e ->
                if (e == null)
                {
                    onComplete(media.objectId,null)
                }
                else
                {
                    onComplete(null,e)
                }
            }
        }

        @JvmStatic
        fun addMediaByFile(file: File, type: String, onComplete: (String?, Exception?) -> Unit)
        {
            val parseFile = ParseFile(file)
            val media = Media()
            with(media)
            {
                this.media = parseFile
                this.type = type
            }
            media.saveInBackground { e ->
                if (e == null)
                {
                    onComplete(media.objectId,null)
                }
                else
                {
                    onComplete(null,e)
                }
            }
        }

        @JvmStatic
        fun getMedia(id: String,onComplete: (Media?, Exception?) -> Unit)
        {
            val query: ParseQuery<Media> = ParseQuery.getQuery(Media::class.java)
            query.getInBackground(id){
                media,exception ->
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

    }
}