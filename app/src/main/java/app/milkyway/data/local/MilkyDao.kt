package com.example.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.milkyway.data.models.MilkyItems


@Dao
interface MilkyDao {

    @Query("SELECT * FROM milkyItems")
    fun getAllMilkyImages() : LiveData<List<MilkyItems>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(milkyItems: List<MilkyItems>)


}