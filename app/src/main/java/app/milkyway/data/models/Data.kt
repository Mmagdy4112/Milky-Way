package app.milkyway.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import app.milkyway.data.converters.StringListConverter
import com.google.gson.annotations.SerializedName
import retrofit2.Converter

@Entity(tableName = "data")
data class Data (
   @PrimaryKey(autoGenerate = true)
   var id:Int,
   @TypeConverters(StringListConverter::class)
   @SerializedName("album") var album : List<String>,
   @SerializedName("center") var center : String,
   @SerializedName("title") var title : String,
   @TypeConverters(StringListConverter::class)
   @SerializedName("keywords") var keywords : List<String>,
   @SerializedName("location") var location : String,
   @SerializedName("nasa_id") var nasaId : String,
   @SerializedName("date_created") var dateCreated : String,
   @SerializedName("media_type") var mediaType : String,
   @SerializedName("description") var description : String

)
