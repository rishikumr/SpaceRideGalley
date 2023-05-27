package com.sample.spaceridegalley.imagelist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sample.spaceridegalley.databinding.FragmentImageListSingleBinding


class ImageListRecyclerViewAdapter(private val values: MutableList<ListItemModel>) : RecyclerView.Adapter<ImageListRecyclerViewAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(newValues: List<ListItemModel> ){
        values.clear()
        values.addAll(newValues)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentImageListSingleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.lowQUrl
        holder.contentView.text = item.title
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(ImageListFragmentDirections.actionImageListFragmentToImageDetailFragment(selectedPosition = position))
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentImageListSingleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    override fun getItemViewType(position: Int): Int {

        return super.getItemViewType(position)
    }
}