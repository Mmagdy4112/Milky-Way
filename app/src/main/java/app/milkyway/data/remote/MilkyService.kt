package app.milkyway.data.remote

import app.milkyway.data.models.MilkyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MilkyService {

    @GET("search")
    suspend fun getAllMilkyImages(@QueryMap options:HashMap<String,String>):Response<MilkyModel>
    @GET("search")
    suspend fun getMilkyItem(@Query("nasa_id") nasaId:String):Response<MilkyModel>
}