package app.milkyway.ui.fragments.milkyDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import app.milkyway.data.models.MilkyItems
import app.milkyway.data.repository.MilkyRepository
import app.milkyway.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.Serializable
import javax.inject.Inject

@HiltViewModel
class MilkyDetailsViewModel  @Inject constructor(
    private val repository: MilkyRepository
) : ViewModel() {


    private val nasaID = MutableLiveData<String>()

    private val _milkyItem = nasaID.switchMap { id ->
        repository.getMilkyItem(id)

    }
    val milkyItem: LiveData<Resource<MilkyItems>> = _milkyItem


    fun start(nasaID: String) {
        this.nasaID.value = nasaID
    }

}
