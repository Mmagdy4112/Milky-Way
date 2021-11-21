package app.milkyway.ui.fragments.milkyDetails

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import app.milkyway.data.models.MilkyItems
import app.milkyway.databinding.FragmentMilkyDetailsBinding
import app.milkyway.utils.Helper
import app.milkyway.utils.Resource
import app.milkyway.utils.autoCleared
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MilkyDetails : Fragment() {

    private var binding: FragmentMilkyDetailsBinding by autoCleared()
    private val viewModel: MilkyDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMilkyDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("nasaID")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.milkyItem.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindMilkuItem(it.data!!)
                    binding.progressBarMilkyDetails.visibility = View.GONE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING -> {
                    binding.progressBarMilkyDetails.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun bindMilkuItem(milkyItems: MilkyItems) {
        val item = milkyItems.data.first()
        binding.tvMilkyDetailsTitle.text = item.title
        binding.tvMilkyDetailsCenter.text = item.center
        binding.tvMilkyDetailsDate.text = Helper.convertDate(item.dateCreated)
        binding.tvMilkyDetailsDesc.setMovementMethod(LinkMovementMethod.getInstance())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvMilkyDetailsDesc.text = Html.fromHtml(item.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }else{
            binding.tvMilkyDetailsDesc.text = Html.fromHtml(item.description)
        }
        Glide.with(binding.root)
            .load(milkyItems.links.first().href)
            .into(binding.ivMilkyDetails)
    }
}