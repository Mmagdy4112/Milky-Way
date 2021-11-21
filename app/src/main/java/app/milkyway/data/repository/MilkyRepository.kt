package app.milkyway.data.repository

import app.milkyway.data.remote.MilkyRemoteDataSource
import app.milkyway.utils.performGetOperation
import com.example.rickandmorty.data.local.MilkyDao
import javax.inject.Inject

class MilkyRepository @Inject constructor(
    private val remoteDataSource: MilkyRemoteDataSource,
    private val localDataSource: MilkyDao
) {
    fun getMilkyItem(id: String) = performGetOperation(
        databaseQuery = { localDataSource.getMilkyItem(id) },
        networkCall = { remoteDataSource.getMilkyItem(id) },
        saveCallResult = { localDataSource.updateItem(it.collection.items[0]) }
    )


    fun getMilkyImages(options:HashMap<String,String>) = performGetOperation(
        databaseQuery = { localDataSource.getAllMilkyImages() },
        networkCall = { remoteDataSource.getMilkyImages(options) },
        saveCallResult = { localDataSource.insertAndUpdateAll(it.collection.items) }
    )
}