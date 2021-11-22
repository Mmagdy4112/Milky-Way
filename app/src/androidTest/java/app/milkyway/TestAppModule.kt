package app.milkyway

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import app.milkyway.data.local.AppDatabase
import app.milkyway.data.local.MilkyDao
import app.milkyway.data.remote.MilkyRemoteDataSource
import app.milkyway.data.remote.MilkyService
import app.milkyway.data.repository.MilkyRepository
import app.milkyway.ui.fragments.milkyImages.MilkyImagesViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("provide_db")
    fun provideDataBase(@ApplicationContext context: Context) =
         Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
}