package com.srijan.travelapp.model

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseUser
import java.io.File

@ParseClassName("User")
class User(): ParseUser() {

    private var user: ParseUser? = getCurrentUser()

    constructor(user: ParseUser?): this()
    {
        this.user = user
    }

    private var name = "";

    fun setName(name: String)
    {
        put("name",name)
    }

    fun getName(): String?
    {
        return user?.getString("name")
    }

    private var profile: ParseFile? = null

    fun setProfile(file: File)
    {

        put("profile",ParseFile(file))
    }

    fun getProfile() : ParseFile?
    {
        return user?.getParseFile("profile")
    }

    override fun getEmail(): String?
    {
        return user?.email
    }

    override fun getUsername(): String? {
        return user?.username
    }




}