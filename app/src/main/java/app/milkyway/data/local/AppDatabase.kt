package com.example.rickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import app.milkyway.data.converters.Converters
import app.milkyway.data.converters.MilkyItemsConverter
import app.milkyway.data.converters.MilkydataConverter
import app.milkyway.data.converters.StringListConverter
import app.milkyway.data.models.Data
import app.milkyway.data.models.Links
import app.milkyway.data.models.MilkyItems
import retrofit2.Converter

@TypeConverters(MilkyItemsConverter::class,MilkydataConverter::class, StringListConverter::class)
@Database(entities = [MilkyItems::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun milkyDao(): MilkyDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "milkyway")
                .fallbackToDestructiveMigration()
                .build()
    }

}