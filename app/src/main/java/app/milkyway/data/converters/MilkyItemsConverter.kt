package app.milkyway.data.converters

import androidx.room.TypeConverter
import app.milkyway.data.models.Data
import app.milkyway.data.models.Links
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MilkyItemsConverter {
    @TypeConverter
    fun fromImagesJson(stat: List<Data>): String {
        return Gson().toJson(stat)
    }

    @TypeConverter
    fun toImagesList(jsonImages: String): List<Data> {
        val notesType = object : TypeToken<List<Data>>() {}.type
        return Gson().fromJson<List<Data>>(jsonImages, notesType)
    }
}
class MilkydataConverter {
    @TypeConverter
    fun fromImagesJson(stat: List<Links>): String {
        return Gson().toJson(stat)
    }

    @TypeConverter
    fun toImagesList(jsonImages: String): List<Links> {
        val notesType = object : TypeToken<List<Links>>() {}.type
        return Gson().fromJson<List<Links>>(jsonImages, notesType)
    }
}
class StringListConverter {
    @TypeConverter
    fun fromImagesJson(stat: List<String>): String {
        return Gson().toJson(stat)
    }

    @TypeConverter
    fun toImagesList(jsonImages: String): List<String> {
        val notesType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson<List<String>>(jsonImages, notesType)
    }
}

abstract class Converters<T> {

    @TypeConverter
    fun mapListToString(value: List<T>): String {
        val gson = Gson()
        val type = object : TypeToken<List<T>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun mapStringToList(value: String): List<T> {
        val gson = Gson()
        val type = object : TypeToken<List<T>>() {}.type
        return gson.fromJson(value, type)
    }
}