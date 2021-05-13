package com.srijan.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.parse.ParseObject
import com.parse.ParseUser
import com.srijan.travelapp.databinding.ActivityMainBinding
import com.srijan.travelapp.model.Demo
import com.srijan.travelapp.model.Post
import com.srijan.travelapp.repository.MediaRepository
import com.srijan.travelapp.repository.PostRepository
import com.srijan.travelapp.repository.UserRepository
import java.io.File
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var activity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var d: Demo  = Demo_One()
//        with(d)
//        {
//            d.text = "text"
//            d.text_one = "text1"
//            d.text_two = "SD"
//        }
//        d.saveInBackground()

        var d = Demo()
        with(d)
        {
            d.text = "DS"
            d.text_one = "@1"
        }

        d.saveInBackground()

        var d2 = Demo()
        with(d2)
        {
            d2.text = "DS"
            d2.text_two = "@1"
        }

        d2.saveInBackground()
//        UserRepository.createUser("Minal Arora","minaalarora567@gmail.com","123456")
//        {
//            user: User?, exception: Exception? ->
//            when
//            {
//                user!=null -> {
//                    Toast.makeText(this, user.username, Toast.LENGTH_SHORT).show()
//                }
//                exception!=null -> {
//                    Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//
//        }

//        UserRepository.loginUser("minaalarora567@gmail.com","123456"){
//                user: User?, exception: Exception? ->
//            when
//            {
//                user!=null -> {
//                    Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show()
//                }
//                exception!=null -> {
//                    Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }

//        UserRepository.logoutUser {
//            b: Boolean? ->
//            Toast.makeText(this, "" + b, Toast.LENGTH_SHORT).show()
//        }

        //var file = File()
//        PostRepository.addMedia(ByteArray(5),"IMAGE"){
//            id,ex ->
//            if (ex == null && id != null)
//            {
//
//                Toast.makeText(this,id, Toast.LENGTH_SHORT).show()
//                var list  = ArrayList<String>()
//                id?.let {
//                    list.add(it)
//                }
//                PostRepository.createPost("hello Minal",list){ post, exception ->
//                    if (exception == null)
//                    {
//                        post?.objectId
//                        Toast.makeText(this, "post", Toast.LENGTH_SHORT).show()
//                    }
//                    else
//                    {
//                        Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//            }
//            else
//            {
//                Toast.makeText(this, ex?.message, Toast.LENGTH_SHORT).show()
//            }
//        }




//        PostRepository.getPost(ParseUser.getCurrentUser()){list, exception ->
//            if (exception == null)
//            {
//                //Toast.makeText(this, list?.get(0)?.comment?.get(0)?.objectId, Toast.LENGTH_SHORT).show()
//                PostRepository.addComment(Post(),"commented"){ comment, exception ->
//
//                    if (exception == null)
//                    {
//                        Toast.makeText(this,comment?.text,Toast.LENGTH_LONG).show()
//                    }
//                    else
//                    {
//                        Toast.makeText(this,exception.message,Toast.LENGTH_LONG).show()
//                    }
//
//                }
//
//            }
//            else
//            {
//
//                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//            }
//        }


//        MediaRepository.getMedia("tdxkUA6T2N"){
//            media, exception ->
//            if (exception == null)
//            {
//                Log.d("minal", "getMedia: " + media?.media?.data)
//
//            }
//            else
//            {
//
//            }
//        }



    }
}

//https://docs.mapbox.com/android/maps/examples/create-a-line-layer/

//https://docs.mapbox.com/android/maps/examples/draw-a-geojson-line/

//https://docs.mapbox.com/android/maps/examples/moving-icon-with-trailing-line/

//https://docs.mapbox.com/android/maps/examples/snaking-directions-route/

//https://docs.mapbox.com/android/maps/examples/style-lines-using-an-identity-property-function/


