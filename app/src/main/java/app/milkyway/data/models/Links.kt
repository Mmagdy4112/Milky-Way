package app.milkyway.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Links (
   @SerializedName("href") var href : String,
   @SerializedName("rel") var rel : String,
   @SerializedName("render") var render : String

)