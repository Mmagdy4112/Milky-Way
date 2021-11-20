package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Items (

   @SerializedName("href") var href : String,
   @SerializedName("data") var data : List<Data>,
   @SerializedName("links") var links : List<Links>

)