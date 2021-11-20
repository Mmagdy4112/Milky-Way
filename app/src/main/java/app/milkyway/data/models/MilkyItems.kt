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
   @PrimaryKey(autoGenerate = true)
   var id:Int,
   @SerializedName("href") var href : String,
   @TypeConverters(MilkyItemsConverter::class)
   @SerializedName("data") var data : List<Data> = listOf(),
   @TypeConverters(MilkydataConverter::class)
   @SerializedName("links") var links : List<Links>

)
