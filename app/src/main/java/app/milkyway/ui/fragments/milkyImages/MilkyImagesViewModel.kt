package app.milkyway.ui.fragments.milkyImages

import androidx.lifecycle.ViewModel
import app.milkyway.data.repository.MilkyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MilkyImagesViewModel @Inject constructor(private val repository: MilkyRepository) :
    ViewModel() {

    val items = repository.getMilkyImages(repoOptions())

    fun repoOptions(): HashMap<String, String> {
        val hMap: HashMap<String, String> = HashMap()
        hMap["q"] = "milky way"
        hMap["year_start"] = "2017"
        hMap["year_end"] = "2017"
        hMap["media_type"] = "image"
        return hMap
    }
}
