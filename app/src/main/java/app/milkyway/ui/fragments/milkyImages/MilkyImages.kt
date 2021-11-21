package app.milkyway.ui.fragments.milkyImages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import app.milkyway.R
import app.milkyway.databinding.FragmentMilkyImagesBinding
import app.milkyway.utils.Resource
import app.milkyway.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MilkyImages : Fragment(), MilkyImagesAdapter.MilkyItemListener {

    private var binding: FragmentMilkyImagesBinding by autoCleared()
    private val viewModel: MilkyImagesViewModel by viewModels()
    private lateinit var adapter: MilkyImagesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMilkyImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = MilkyImagesAdapter(this)
        binding.recyclerMilkyImages.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.items.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedMilky(nasaID: String) {
        findNavController().navigate(
            R.id.action_milkyImages_to_milkyDetails,
            bundleOf("nasaID" to nasaID)
        )
    }
}