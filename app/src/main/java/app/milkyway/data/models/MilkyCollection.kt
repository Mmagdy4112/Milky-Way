package app.milkyway.data.models

import com.google.gson.annotations.SerializedName


data class MilkyCollection (

   @SerializedName("version") var version : String,
   @SerializedName("href") var href : String,
   @SerializedName("items") var items : List<MilkyItems>,
   @SerializedName("metadata") var metadata : Metadata

)