package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Collection (

   @SerializedName("version") var version : String,
   @SerializedName("href") var href : String,
   @SerializedName("items") var items : List<Items>,
   @SerializedName("metadata") var metadata : Metadata

)