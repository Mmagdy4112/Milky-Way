package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Links (

   @SerializedName("href") var href : String,
   @SerializedName("rel") var rel : String,
   @SerializedName("render") var render : String

)