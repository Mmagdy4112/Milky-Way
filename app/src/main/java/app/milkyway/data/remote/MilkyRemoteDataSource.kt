package app.milkyway.data.remote

import javax.inject.Inject

class MilkyRemoteDataSource @Inject constructor(
    private val milkyService: MilkyService
): BaseDataSource() {

    suspend fun getMilkyImages(options:HashMap<String,String>) = getResult { milkyService.getAllMilkyImages(options) }
    suspend fun getMilkyItem(id:String) = getResult { milkyService.getMilkyItem(id)}

}