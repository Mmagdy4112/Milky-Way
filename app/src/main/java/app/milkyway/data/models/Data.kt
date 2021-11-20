package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Data (

   @SerializedName("album") var album : List<String>,
   @SerializedName("center") var center : String,
   @SerializedName("title") var title : String,
   @SerializedName("keywords") var keywords : List<String>,
   @SerializedName("location") var location : String,
   @SerializedName("nasa_id") var nasaId : String,
   @SerializedName("date_created") var dateCreated : String,
   @SerializedName("media_type") var mediaType : String,
   @SerializedName("description") var description : String

)