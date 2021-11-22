package app.milkyway.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import app.milkyway.data.models.Data
import app.milkyway.data.models.Links
import app.milkyway.data.models.MilkyItems
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class MilkyDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    var InstantTaskExecutorRule = InstantTaskExecutorRule()
    @Inject
    @Named("provide_db")
    lateinit var db: AppDatabase
    private lateinit var dao: MilkyDao


    @Before
    fun setup(){
        hiltRule.inject()
        dao = db.milkyDao()

    }

    @After
    fun closeDB(){
        db.close()
    }

    @Test
    fun insert() = runBlocking{
        var list = listOf(createItem())
        dao.insertAll(list)
        val items = dao.getAllMilkyImages().getOrAwaitValue()
        assertThat(items).contains(createItem())
    }

    @Test
    fun update() = runBlocking{
        val item = createItem()
        dao.insert(item)
        item.href = "sadad"
        dao.update(item)
        val items = dao.getMilkyItem(item.nasaID).getOrAwaitValue()
        assertThat(items.href).isEqualTo("sadad")
    }

    fun createItem():MilkyItems{
        val data = listOf(
            Data(
                listOf("Test"),
                "GSFC",
                "A monster in the Milky Way",
                listOf("A monster in the Milky Way"),
                "Greenbelt, MD",
                "GSFC_20171208_Archive_e001362",
                "2017-12-08T00:00:00Z",
                "image",
                "This image shows the star-studded center of the Milky Way towards the constellation of Sagittarius. The crowded center of our galaxy "
            )
        )
        val links = listOf(
            Links(
                "https://images-assets.nasa.gov/image/GSFC_20171208_Archive_e001362/GSFC_20171208_Archive_e001362~thumb.jpg",
                "preview",
                "image"
            )
        )
        val milkyItem = MilkyItems(
            "https://images-assets.nasa.gov/image/GSFC_20171208_Archive_e001362/collection.json",
            data,
            links,
            "GSFC_20171208_Archive_e001362")
        return  milkyItem
    }
}