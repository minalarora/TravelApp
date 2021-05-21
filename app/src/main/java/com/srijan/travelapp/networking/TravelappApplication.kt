package com.srijan.travelapp.networking

import android.app.Application
import com.parse.Parse
import com.parse.ParseObject
import com.srijan.travelapp.model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class TravelappApplication: Application() {

    private val appId = "8NIACeVi0egK9RyFKhuyN6uJOMGUz8d1oXF8FBpS"

    private val clientKey = "9l2mt8TgMJ9dlEBnQs6NXy14mh90V3U1BkYDI08F"

    private val serverName = "https://parseapi.back4app.com/"

    override fun onCreate() {
        super.onCreate()
        // Use for troubleshooting -- remove this line for production
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG)

        // Use for monitoring Parse OkHttp traffic
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        // See https://square.github.io/okhttp/3.x/logging-interceptor/ to see the options.
        val builder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        builder.networkInterceptors().add(httpLoggingInterceptor)

        ParseObject.registerSubclass(Post::class.java)
        ParseObject.registerSubclass(Comment::class.java)
        ParseObject.registerSubclass(Media::class.java)
        ParseObject.registerSubclass(Chat::class.java)
        ParseObject.registerSubclass(Message::class.java)
       // ParseObject.registerSubclass(Demo_One::class.java)
        // set applicationId, and server server based on the values in the back4app settings.
        // any network interceptors must be added with the Configuration Builder given this syntax
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(appId)
                .clientKey(clientKey)
                .server(serverName)
                .clientBuilder(builder)
                .build()
        );


    }
}