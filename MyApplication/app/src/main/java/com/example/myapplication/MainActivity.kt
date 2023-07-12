package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        val gson : Gson = GsonBuilder()
            .setLenient()
            .create()
        val retro = Retrofit.Builder()
            .baseUrl("https://3f371aa7-73f8-4eab-b41d-65a00c4cb7ad.mock.pstmn.io")
            .addConverterFactory(
                GsonConverterFactory.create(gson))
            .build()

        val test = retro.create(test::class.java)
        test.getTest().enqueue(object : retrofit2.Callback<obj> {
            override fun onResponse(call: Call<obj>, response: Response<obj>) {
                Log.d("testtest", response.toString())
                Log.d("testtest", call.toString())
            }

            override fun onFailure(call: Call<obj>, t: Throwable) {
                Log.d("t", t.toString())
            }
        })
        return super.onCreateView(name, context, attrs)
    }
}

