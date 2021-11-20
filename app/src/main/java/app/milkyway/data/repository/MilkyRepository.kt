package app.milkyway.data.repository

import app.milkyway.data.remote.MilkyRemoteDataSource
import app.milkyway.utils.performGetOperation
import com.example.rickandmorty.data.local.MilkyDao
import javax.inject.Inject

class MilkyRepository @Inject constructor(
    private val remoteDataSource: MilkyRemoteDataSource,
    private val localDataSource: MilkyDao
) {



    fun getMilkyImages(options:HashMap<String,String>) = performGetOperation(
        databaseQuery = { localDataSource.getAllMilkyImages() },
        networkCall = { remoteDataSource.getMilkyImages(options) },
        saveCallResult = { localDataSource.insertAll(it.collection.items) }
    )
}