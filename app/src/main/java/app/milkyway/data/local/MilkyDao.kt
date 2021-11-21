package com.example.rickandmorty.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import app.milkyway.data.models.MilkyItems


@Dao
interface MilkyDao {

    @Query("SELECT * FROM milkyItems")
    fun getAllMilkyImages(): LiveData<List<MilkyItems>>

    @Query("SELECT * FROM milkyItems WHERE nasaID = :nasaID ")
    fun getMilkyItem(nasaID: String): LiveData<MilkyItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(milkyItems: List<MilkyItems>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(milkyItem: MilkyItems)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(item: MilkyItems): Int
    suspend fun insertAndUpdateAll(data: List<MilkyItems>) {
        var items = data
        for (item in items) {
            item.nasaID = item.data.first().nasaId
        }
        insertAll(items)
    }

    suspend fun updateItem(data: MilkyItems) {
        data.nasaID = data.data.first().nasaId
        update(data)
    }
}