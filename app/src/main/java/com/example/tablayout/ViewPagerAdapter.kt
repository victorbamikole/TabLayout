package com.example.tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.databinding.ViewPagerItemBinding

class ViewPagerAdapter(private val item: List<ViewData>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding: ViewPagerItemBinding = ViewPagerItemBinding.bind(itemView)
        private val image = binding.image

        fun  bind(item: ViewData){
            image.setImageResource(item.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item,parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = item[position]
        holder.bind(currentImage)

    }

    override fun getItemCount(): Int {
        return item.size
    }
}