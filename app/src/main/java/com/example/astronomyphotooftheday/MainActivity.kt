package com.example.astronomyphotooftheday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var getImageURL = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val imageView =findViewById<ImageView>(R.id.NasaImage)

        getNasaImageUrl()

        button.setOnClickListener{
        }


    }
    private fun getNasaImageUrl(){
        val client = AsyncHttpClient()

        client["https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=Kh18VR3A1gzzt2u2T7KVAfyYa6ohUgCK9yvjlw2o", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Dog", "response successful$json")

                getImageURL = json.jsonObject.getString("message")
                Log.d("getImageURL",getImageURL)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("NASA Error", errorResponse)
            }
        }]

    }
}