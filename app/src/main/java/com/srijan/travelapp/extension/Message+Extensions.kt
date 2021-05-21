package com.srijan.travelapp.extension

import com.parse.ParseRelation
import com.parse.ParseUser
import com.srijan.travelapp.model.Chat
import com.srijan.travelapp.model.Message

fun Message.getAllMessages(chat: Chat, page: Int, onComplete: (List<Message>, Exception?) -> Unit)
{
    chat.messages?.let {
        var limit = 100
        var skip = limit * (page - 1)
        it.query.apply {
            this.orderByDescending("createdAt");
            this.limit = limit
            this.skip = skip
            findInBackground { objects, e ->
                when {
                    objects != null -> {
                        onComplete(objects, null)
                    }
                    e != null -> {
                        onComplete(emptyList(),e)
                    }
                }
        }
        }
    } ?: onComplete(emptyList(), Exception("Unable to fetch messages!"))
}
//TODO provide timestamp with the help of Joda
fun Message.addText(chat: Chat,text: String,onComplete: (Boolean) -> Unit)
{
    val message = Message()
    message.message = text
    message.type = "TEXT"
    message.who = ParseUser.getCurrentUser()
    message.date = "0"

    chat.messages?.let {
        it.add(message)
        chat.saveInBackground { e ->
            if (e == null)
            {
                onComplete(true)
            }
            else
            {
                onComplete(false)
            }
        }
    } ?: onComplete(false)
}