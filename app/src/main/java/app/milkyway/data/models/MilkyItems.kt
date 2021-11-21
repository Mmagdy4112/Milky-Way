package app.milkyway.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import app.milkyway.data.converters.MilkyItemsConverter
import app.milkyway.data.converters.MilkydataConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "milkyItems")
data class MilkyItems (
   @SerializedName("href") var href : String,
   @TypeConverters(MilkyItemsConverter::class)
   @SerializedName("data") var data : List<Data>,
   @TypeConverters(MilkydataConverter::class)
   @SerializedName("links") var links : List<Links>,
   @PrimaryKey
   @SerializedName("nasaID") var nasaID:String

)
