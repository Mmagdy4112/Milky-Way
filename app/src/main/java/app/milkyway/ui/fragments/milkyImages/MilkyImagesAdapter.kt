package app.milkyway.ui.fragments.milkyImages;


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.milkyway.data.models.MilkyItems
import app.milkyway.databinding.ItemMilyImagesBinding
import app.milkyway.utils.Helper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import java.text.SimpleDateFormat


class MilkyImagesAdapter(private val listener: MilkyItemListener) :
    RecyclerView.Adapter<MilkyViewHolder>() {

    interface MilkyItemListener {
        fun onClickedMilky(nasaID: String)
    }

    private val items = ArrayList<MilkyItems>()

    fun setItems(items: ArrayList<MilkyItems>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun

            onCreateViewHolder(parent: ViewGroup, viewType: Int): MilkyViewHolder {
        val binding: ItemMilyImagesBinding =
            ItemMilyImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MilkyViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MilkyViewHolder, position: Int) =
        holder.bind(items[position])
}

class MilkyViewHolder(
    private val itemBinding: ItemMilyImagesBinding,
    private val listener: MilkyImagesAdapter.MilkyItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var milkyItem: MilkyItems

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: MilkyItems) {
        this.milkyItem = item
        itemBinding.tvMilkyImageItemName.text = item.data.first().title
        itemBinding.tvMilkyImageItemCenter.text = item.data.first().center

        val date = Helper.convertDate(item.data.first().dateCreated)
        itemBinding.tvMilkyImageItemDate.text = date

        Glide.with(itemBinding.root)
            .load(item.links.first().href)
            .into(itemBinding.imageMilkyImageItem)
    }

    override fun onClick(v: View?) {
        listener.onClickedMilky(milkyItem.data.first().nasaId)
    }
}
