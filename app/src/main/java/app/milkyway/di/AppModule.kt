package app.milkyway.di

import android.content.Context
import app.milkyway.MainApplication
import app.milkyway.data.remote.MilkyRemoteDataSource
import app.milkyway.data.remote.MilkyService
import app.milkyway.data.repository.MilkyRepository
import app.milkyway.data.local.AppDatabase
import app.milkyway.data.local.MilkyDao
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://images-api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideMilkyService(retrofit: Retrofit): MilkyService = retrofit.create(MilkyService::class.java)

    @Singleton
    @Provides
    fun provideMilkyRemoteDataSource(milkyService: MilkyService) = MilkyRemoteDataSource(milkyService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideMilkyDao(db: AppDatabase) = db.milkyDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: MilkyRemoteDataSource,
                          localDataSource: MilkyDao
    ) =
        MilkyRepository(remoteDataSource, localDataSource)
}