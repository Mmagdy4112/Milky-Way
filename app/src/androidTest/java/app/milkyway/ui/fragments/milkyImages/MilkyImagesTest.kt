package app.milkyway.ui.fragments.milkyImages

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import app.milkyway.R
import app.milkyway.data.local.AppDatabase
import app.milkyway.data.repository.MilkyRepository
import app.milkyway.launchFragmentInHiltContainer
import com.nhaarman.mockitokotlin2.refEq
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject
import com.google.common.truth.Truth.assertThat
import javax.inject.Named


@MediumTest
@HiltAndroidTest
@ExperimentalCoroutinesApi
class MilkyImagesTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    lateinit var milkyViewModel: MilkyImagesViewModel


    @Before
    fun setup() {
        hiltRule.inject()
    }
    @Test
    fun testNavigationToSecondScreen() {
        val mockNavController = mock(NavController::class.java)
        launchFragmentInHiltContainer<MilkyImages> {
            Navigation.setViewNavController(requireView(), mockNavController)
            milkyViewModel = this.viewModel
        }
        Thread.sleep(5_000)
        var pos = 0
        onView(withId(R.id.recycler_milky_images)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(pos, click()))
        var nasaID = milkyViewModel.items.value?.data?.get(pos)?.data!![0].nasaId
        verify(mockNavController).navigate(refEq(R.id.action_milkyImages_to_milkyDetails),
            refEq( bundleOf("nasaID" to  nasaID))
        )
    }

}



