package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class obj (
    @Expose
    @SerializedName("test")
    var test:String,
        )