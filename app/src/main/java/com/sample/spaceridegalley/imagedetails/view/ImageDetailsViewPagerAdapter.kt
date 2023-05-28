package com.sample.spaceridegalley.imagedetails.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.sample.spaceridegalley.R
import com.sample.spaceridegalley.databinding.FragmentImageDetailSingleBinding
import com.sample.spaceridegalley.imagedetails.domain.model.DetailItemModel

class ImageDetailsViewPagerAdapter(private val values: MutableList<DetailItemModel>) : RecyclerView.Adapter<ImageDetailsViewPagerAdapter.ViewHolder>() {

    fun submitItems(newValues: List<DetailItemModel>) {
        values.clear()
        values.addAll(newValues)
        notifyItemRangeInserted(0, values.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentImageDetailSingleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val context = holder.itemView.context
        val circularProgressDrawable =
            CircularProgressDrawable(context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                start()
            }

        val requestOptions = RequestOptions().apply {
            placeholder(circularProgressDrawable)
            skipMemoryCache(true)
            fitCenter()
            error(R.drawable.ic_image_not_found)
            diskCacheStrategy(DiskCacheStrategy.ALL)
        }

        Glide.with(holder.itemView.context)
            .load(item.hdurl) // passing your url to load image.
            .apply(requestOptions) // here you have all options you need
            .into(holder.imgView) // pass imageView reference to appear the image.

        holder.itemTitle.text = item.title
        holder.itemOwner.text = item.owner
        holder.itemDesc.text = item.explanation
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentImageDetailSingleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imgView: ImageView = binding.itemImage
        val itemOwner: TextView = binding.itemOwner
        val itemTitle: TextView = binding.itemTitle
        val itemDesc: TextView = binding.itemDesc
    }
}
