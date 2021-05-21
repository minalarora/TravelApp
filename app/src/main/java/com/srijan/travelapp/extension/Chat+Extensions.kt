package com.srijan.travelapp.extension

import com.parse.ParseQuery
import com.parse.ParseUser
import com.srijan.travelapp.model.Chat
import kotlin.collections.ArrayList

//TODO YET TO DECIDE WHICH TO CALL FIRST
//TODO CREATE CHAT OR SAVING OTHER USER ID IN CHAT ARRAY
fun Chat.createChat(me: String, other: String , onComplete: (Chat?, Exception?) -> Unit)
{

    if (ParseUser.getCurrentUser() != null)
    {
        ParseUser.getCurrentUser().addAllUnique("chats", listOf(other));
        ParseUser.getCurrentUser().saveInBackground() { e ->
            if (e == null)
            {
                val chat = Chat()
                chat.users = listOf(me,other).toMutableList()
                chat.saveInBackground { error ->
                    if (error == null)
                    {
                        onComplete(chat,null)
                    }
                    else
                    {
                        onComplete(null,error)
                    }
                }
            }
            else
            {
                onComplete(null,  Exception("Unable to create chat!"))
            }

        };
    }
    else
    {
        onComplete(null, Exception("User not found"))
    }
}

//TODO ADD A CHECK HERE IF USER IS STORE IN ARRAY OF USER, BUT CHAT OBJ IS NOT CREATED
fun Chat.getChat(me: String, other: String, onComplete: (Chat?, Exception?) -> Unit)
{
    val query: ParseQuery<Chat> = ParseQuery.getQuery(Chat::class.java)
    query.whereContainsAll("users", ArrayList<String>().apply {
        add(me)
        add(other)
    } );
    query.getFirstInBackground { obj, e ->
        when {
            obj!=null -> {
                onComplete(obj, null)
            }
            e!=null -> onComplete(null, e)
        }
    }
}

fun Chat.verifyUserChat(user: String, onComplete: (Chat?, Exception?) -> Unit)
{
    if (ParseUser.getCurrentUser() != null)
    {
        val fulllist : List<String> = ParseUser.getCurrentUser().getList<String>("chats") ?: emptyList()
        val userlist : List<String> = fulllist.filter { it == user }
        if (userlist.isEmpty())
        {
            createChat(ParseUser.getCurrentUser().objectId, user, onComplete)
        }
        else
        {
            getChat(ParseUser.getCurrentUser().objectId, user, onComplete)
        }
    }
    else
    {
        onComplete(null, Exception("User not found"))
    }
}

fun Chat.getChatList(users: List<String>, page: Int, onComplete: (List<Chat>, Exception?) -> Unit)
{
    if (users.isEmpty())
    {
        onComplete( emptyList(), null)
    }
    else
    {
        var limit = 100
        var skip = limit * (page - 1)
        val query: ParseQuery<Chat> = ParseQuery.getQuery(Chat::class.java)
        query.whereContainedIn("users", listOf(ParseUser.getCurrentUser().objectId));
        query.orderByDescending("updatedAt");
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

