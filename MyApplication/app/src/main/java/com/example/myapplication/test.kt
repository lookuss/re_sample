package com.example.myapplication

import retrofit2.http.GET
import java.io.InputStream

interface test {
@GET("/")
fun getTest(): retrofit2.Call<obj>
}