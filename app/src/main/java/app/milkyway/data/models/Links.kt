package app.milkyway.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "links")
data class Links (
   @PrimaryKey(autoGenerate = true)
   var id:Int,
   @SerializedName("href") var href : String,
   @SerializedName("rel") var rel : String,
   @SerializedName("render") var render : String

)